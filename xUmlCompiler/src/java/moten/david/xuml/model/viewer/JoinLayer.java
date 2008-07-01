package moten.david.xuml.model.viewer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import model.AssociationEndPrimary;
import model.Specialization;
import model.SpecializationGroup;
import moten.david.util.swing.ComponentUtil;

public class JoinLayer extends JPanel {

	private static final long serialVersionUID = -7071675681715201402L;

	private static final float FONT_SIZE = 10f;
	private static final int POINTS_PER_SIDE = 4;
	private static final int ARROW_SIDE = 6;
	private static final int ARROW_DEPTH = 10;
	private static final int SPECIALIZATION_JOIN_LENTH = 60;

	private final SystemViewer viewer;

	private static Stroke STROKE_THIN_DASHED = new BasicStroke(1.0f, // line
			// width
			/* cap style */BasicStroke.CAP_BUTT,
			/* join style, miter limit */BasicStroke.JOIN_BEVEL, 1.0f,
			/* the dash pattern */new float[] { 5.0f, 5.0f },
			/* the dash phase */0.0f); /* on 8, off 3, on 2, off 3 */

	public JoinLayer(SystemViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void paint(Graphics g) {
		// super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g);
		Set<Point> usedPoints = new HashSet<Point>();
		for (ClassComponent cc : viewer.getClassComponents()) {
			for (AssociationEndPrimary p : cc.getClass_()
					.getAssociationEndPrimary()) {
				ClassComponent other = viewer.getClassComponent(p
						.getAssociation().getSecondary().getClass_());
				ClassComponent assClass = null;
				if (p.getAssociation().getAssociationClass() != null) {
					assClass = viewer.getClassComponent(p.getAssociation()
							.getAssociationClass());
				}
				joinComponents(g, usedPoints, cc, other, p.getAssociation()
						.getName(), assClass);
			}
			for (SpecializationGroup group : cc.getClass_()
					.getSpecializationGroup()) {
				joinComponents(g, usedPoints, viewer, group, cc);
			}
		}
	}

	private void joinComponents(Graphics g, Set<Point> usedPoints,
			SystemViewer viewer, SpecializationGroup group,
			ClassComponent superComponent) {
		Point centreOfSpecializations = new Point(0, 0);
		for (Specialization sp : group.getSpecialization()) {
			Component c = viewer.getClassComponent(sp);
			Point centre = ComponentUtil.getCentre(c.getBounds());
			centreOfSpecializations.x += centre.x;
			centreOfSpecializations.y += centre.y;
		}
		centreOfSpecializations.x /= group.getSpecialization().size();
		centreOfSpecializations.y /= group.getSpecialization().size();
		Rectangle r = new Rectangle(centreOfSpecializations);

		Point[] points = ComponentUtil.getBestJoin(usedPoints, superComponent
				.getBounds(), r);

		Point p1 = points[0];
		Graphics2D g2d = (Graphics2D) g;

		Point joinPoint;
		final int joinLength = SPECIALIZATION_JOIN_LENTH;
		if (p1.x == superComponent.getBounds().x)
			joinPoint = new Point(p1.x - joinLength, p1.y);
		else if (p1.x == superComponent.getBounds().x
				+ superComponent.getBounds().width)
			joinPoint = new Point(p1.x + joinLength, p1.y);
		else if (p1.y == superComponent.getBounds().y)
			joinPoint = new Point(p1.x, p1.y - joinLength);
		else
			joinPoint = new Point(p1.x, p1.y + joinLength);
		for (Specialization sp : group.getSpecialization()) {
			Point p = getBestJoin(usedPoints, viewer.getClassComponent(sp),
					joinPoint);
			g2d.drawLine(p.x, p.y, joinPoint.x, joinPoint.y);
		}
		int arrowDepth = ARROW_DEPTH;
		int arrowSide = ARROW_SIDE;
		double length = ComponentUtil.getDistance(p1, joinPoint);
		double xFactor = (joinPoint.x - p1.x) / length;
		double yFactor = (joinPoint.y - p1.y) / length;
		double theta = Math.atan2(joinPoint.x - p1.x, joinPoint.y - p1.y);
		Point mark = new Point((int) (xFactor * arrowDepth + p1.x),
				(int) (yFactor * arrowDepth + p1.y));
		Point bottom = new Point((int) (mark.x + arrowSide * Math.cos(-theta)),
				(int) (mark.y + arrowSide * Math.sin(-theta)));
		Point top = new Point((int) (mark.x - arrowSide * Math.cos(-theta)),
				(int) (mark.y - arrowSide * Math.sin(-theta)));

		g2d.drawLine(joinPoint.x, joinPoint.y, mark.x, mark.y);

		// draw the arrow head
		Polygon p = new Polygon();
		p.addPoint(mark.x, mark.y);
		p.addPoint(bottom.x, bottom.y);
		p.addPoint(p1.x, p1.y);
		p.addPoint(top.x, top.y);
		g2d.drawPolygon(p);

		// draw the specialization group label
		Point lineCentre = ComponentUtil.getCentre(joinPoint, mark);
		String label = group.getName();
		drawCentredString(g2d, label, lineCentre, getBackground());
	}

	private void drawCentredString(Graphics2D g2d, String label, Point centre,
			Color background) {
		int width = g2d.getFontMetrics().stringWidth(label);
		int ascent = g2d.getFontMetrics().getMaxAscent();
		int descent = g2d.getFontMetrics().getMaxDescent();
		g2d.setBackground(background);
		g2d.clearRect(centre.x - width / 2 - 1, centre.y - ascent / 2,
				width + 2, ascent + descent);
		g2d.drawString(label, centre.x - width / 2, centre.y + ascent / 2);
	}

	private Point getBestJoin(Set<Point> usedPoints, Component component,
			Point p) {
		Double shortestDistance = null;
		Point[] points = ComponentUtil.getPoints(component, POINTS_PER_SIDE);
		Point centre = ComponentUtil.getCentre(component.getBounds());
		Point bestPoint = null;
		for (Point point : points) {
			if (!usedPoints.contains(point)) {
				double distance = ComponentUtil.getDistance(point, p)
						+ ComponentUtil.getDistance(point, centre);
				if (shortestDistance == null || distance < shortestDistance) {
					shortestDistance = distance;
					bestPoint = point;
				}
			}
		}
		usedPoints.add(bestPoint);
		return bestPoint;
	}

	private void joinComponents(Graphics g, Set<Point> usedPoints,
			ClassComponent c1, ClassComponent c2, String label,
			ClassComponent joinToCentre) {
		Point p1 = ComponentUtil.getCentre(c1.getBounds());
		Point p2 = ComponentUtil.getCentre(c2.getBounds());
		Point[] points = ComponentUtil.getBestJoin(usedPoints, c1, c2);
		p1 = points[0];
		p2 = points[1];
		Graphics2D g2d = (Graphics2D) g;
		if (c1 == c2) {
			Point centre = ComponentUtil.getCentre(p1, p2);
			double dist = ComponentUtil.getDistance(centre, p1);
			g2d.drawOval(centre.x - (int) dist * 3 / 2, centre.y - (int) dist
					* 3 / 2, 3 * (int) dist, 3 * (int) dist);
		} else
			g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
		if (joinToCentre != null) {
			Point centre = ComponentUtil.getCentre(p1, p2);
			Point other = ComponentUtil.getCentre(joinToCentre.getBounds());
			Stroke stroke = g2d.getStroke();
			g2d.setStroke(STROKE_THIN_DASHED);
			g2d.drawLine(centre.x, centre.y, other.x, other.y);
			g2d.setStroke(stroke);
		}
		Point p3 = ComponentUtil.getCentre(p1, p2);
		g2d.setFont(g.getFont().deriveFont(FONT_SIZE));

		int width = g2d.getFontMetrics().stringWidth(label);
		int ascent = g2d.getFontMetrics().getMaxAscent();
		int descent = g2d.getFontMetrics().getMaxDescent();
		Color foreground = g2d.getColor();
		g2d.setColor(getBackground());
		g2d.fillRect(p3.x - width / 2 - 1, p3.y - ascent / 2, width + 2, ascent
				+ descent);
		g2d.setColor(foreground);
		int labelX = p3.x - width / 2;
		int labelY = p3.y + ascent / 2;
		if (c1 == c2) {
			int x = labelX;
			int y = labelY;
			for (int i : new int[] { -1, 0, 1 }) {
				for (int j : new int[] { -1, 0, 1 }) {
					int xTemp = labelX + i * ascent - c1.getX();
					int yTemp = labelY + j * (ascent + descent) - c1.getY();
					if (!c1.contains(new Point(xTemp, yTemp))) {
						x = xTemp;
						y = yTemp;
					}
				}
			}
			labelX = x + c1.getX();
			labelY = y + c1.getY();
		}
		g2d.drawString(label, labelX, labelY);
	}

}