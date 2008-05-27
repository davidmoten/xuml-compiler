package moten.david.uml.xuml.model.viewer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import model.AssociationEndPrimary;
import model.Specialization;
import model.SpecializationGroup;

public class JoinLayer extends JPanel {

	private static final long serialVersionUID = -7071675681715201402L;
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
		Point[] points = getBestJoin(usedPoints, superComponent, viewer
				.getClassComponent(group.getSpecialization().get(0)));
		Point p1 = points[0];
		Point p2 = points[1];
		Graphics2D g2d = (Graphics2D) g;

		Point joinPoint;
		final int joinLength = 50;
		if (p1.x == superComponent.getX())
			joinPoint = new Point(p1.x - joinLength, p1.y);
		else if (p1.x == superComponent.getX() + superComponent.getWidth())
			joinPoint = new Point(p1.x + joinLength, p1.y);
		else if (p1.y == superComponent.getY())
			joinPoint = new Point(p1.x, p1.y - joinLength);
		else
			joinPoint = new Point(p1.x, p1.y + joinLength);
		for (Specialization sp : group.getSpecialization()) {
			Point p = getBestJoin(usedPoints, viewer.getClassComponent(sp),
					joinPoint);
			g2d.drawLine(p.x, p.y, joinPoint.x, joinPoint.y);
		}
		int arrowDepth = 10;
		int arrowSide = 6;
		double length = getDistance(p1, joinPoint);
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
		Polygon p = new Polygon();
		p.addPoint(mark.x, mark.y);
		p.addPoint(bottom.x, bottom.y);
		p.addPoint(p1.x, p1.y);
		p.addPoint(top.x, top.y);
		g2d.drawPolygon(p);

	}

	private Point getBestJoin(Set<Point> usedPoints, Component component,
			Point p) {
		Double shortestDistance = null;
		Point[] points = getPoints(component);
		Point centre = getCentre(component);
		Point bestPoint = null;
		for (Point point : points) {
			if (!usedPoints.contains(point)) {
				double distance = getDistance(point, p)
						+ getDistance(point, centre);
				if (shortestDistance == null || distance < shortestDistance) {
					shortestDistance = distance;
					bestPoint = point;
				}
			}
		}
		usedPoints.add(bestPoint);
		return bestPoint;
	}

	private Point[] getBestJoin(Set<Point> usedPoints, Component aComponent,
			Component bComponent) {

		Point[] aPoints = getPoints(aComponent);
		Point[] bPoints = getPoints(bComponent);
		Double shortestDistance = null;
		Point centreA = getCentre(aComponent);
		Point centreB = getCentre(bComponent);
		Point bestA = null;
		Point bestB = null;
		for (Point a : aPoints) {
			for (Point b : bPoints) {
				if (!usedPoints.contains(a) && !usedPoints.contains(b)
						&& !a.equals(b)) {
					double distance = getDistance(a, b)
							+ getDistance(a, centreA) + getDistance(b, centreB);
					if (shortestDistance == null || distance < shortestDistance) {
						shortestDistance = distance;
						bestA = a;
						bestB = b;
					}
				}
			}
		}
		usedPoints.add(bestA);
		usedPoints.add(bestB);
		return new Point[] { bestA, bestB };
	}

	private static double getDistance(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	private Point[] getPoints(Component c) {
		int numPoints = 4;
		Point[] points = new Point[4 * numPoints];
		for (int i = 0; i < numPoints; i++) {
			points[i] = new Point(c.getX() + i * c.getWidth() / numPoints, c
					.getY());
			points[numPoints + i] = new Point(c.getX() + i * c.getWidth()
					/ numPoints, c.getY() + c.getHeight());
			points[2 * numPoints + i] = new Point(c.getX(), c.getY() + i
					* c.getHeight() / numPoints);
			points[3 * numPoints + i] = new Point(c.getX() + c.getWidth(), c
					.getY()
					+ i * c.getHeight() / numPoints);
		}
		return points;
	}

	private void joinComponents(Graphics g, Set<Point> usedPoints,
			ClassComponent superComponent, ClassComponent subComponent) {
		Point[] points = getBestJoin(usedPoints, superComponent, subComponent);
		Point p1 = points[0];
		Point p2 = points[1];
		Graphics2D g2d = (Graphics2D) g;

		int arrowDepth = 10;
		int arrowSide = 6;
		double length = getDistance(p1, p2);
		double xFactor = (p2.x - p1.x) / length;
		double yFactor = (p2.y - p1.y) / length;
		double theta = Math.atan2(p2.x - p1.x, p2.y - p1.y);
		Point mark = new Point((int) (xFactor * arrowDepth + p1.x),
				(int) (yFactor * arrowDepth + p1.y));
		Point bottom = new Point((int) (mark.x + arrowSide * Math.cos(-theta)),
				(int) (mark.y + arrowSide * Math.sin(-theta)));
		Point top = new Point((int) (mark.x - arrowSide * Math.cos(-theta)),
				(int) (mark.y - arrowSide * Math.sin(-theta)));
		g2d.drawLine(p2.x, p2.y, mark.x, mark.y);
		Polygon p = new Polygon();
		p.addPoint(mark.x, mark.y);
		p.addPoint(bottom.x, bottom.y);
		p.addPoint(p1.x, p1.y);
		p.addPoint(top.x, top.y);
		g2d.drawPolygon(p);

	}

	private void joinComponents(Graphics g, Set<Point> usedPoints,
			ClassComponent c1, ClassComponent c2, String label,
			ClassComponent joinToCentre) {
		Point p1 = getCentre(c1);
		Point p2 = getCentre(c2);
		Point[] points = getBestJoin(usedPoints, c1, c2);
		p1 = points[0];
		p2 = points[1];
		Graphics2D g2d = (Graphics2D) g;
		if (c1 == c2) {
			Point centre = getCentre(p1, p2);
			double dist = getDistance(centre, p1);
			g2d.drawOval(centre.x - (int) dist * 3 / 2, centre.y - (int) dist
					* 3 / 2, 3 * (int) dist, 3 * (int) dist);
		} else
			g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
		if (joinToCentre != null) {
			Point centre = getCentre(p1, p2);
			Point other = getCentre(joinToCentre);
			Stroke stroke = g2d.getStroke();
			g2d.setStroke(STROKE_THIN_DASHED);
			g2d.drawLine(centre.x, centre.y, other.x, other.y);
			g2d.setStroke(stroke);
		}
		Point p3 = getCentre(p1, p2);
		g2d.setFont(g.getFont().deriveFont(10f));

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

	private static Point getCentre(Component c) {
		Point p = new Point();
		p.x = c.getX() + c.getSize().width / 2;
		p.y = c.getY() + c.getSize().height / 2;
		return p;
	}

	private static Point getCentre(Point p1, Point p2) {
		Point p = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		return p;
	}

}
