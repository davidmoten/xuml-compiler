package moten.david.uml.xuml.model.viewer.state;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class JoinLayer extends JPanel {

	private static final long serialVersionUID = -7071675681715201402L;
	private final List<StateComponent> stateComponents;

	public JoinLayer(List<StateComponent> stateComponents) {
		this.stateComponents = stateComponents;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Set<Point> usedPoints = new HashSet<Point>();

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
				if (!usedPoints.contains(a) && !usedPoints.contains(b)) {
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
			Component c1, Component c2, String label) {
		Point p1 = getCentre(c1);
		Point p2 = getCentre(c2);
		Point[] points = getBestJoin(usedPoints, c1, c2);
		p1 = points[0];
		p2 = points[1];

		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		Point p3 = getCentre(p1, p2);
		g.setFont(g.getFont().deriveFont(10f));

		int width = g.getFontMetrics().stringWidth(label);
		int ascent = g.getFontMetrics().getMaxAscent();
		int descent = g.getFontMetrics().getMaxDescent();
		Color foreground = g.getColor();
		g.setColor(getBackground());
		g.fillRect(p3.x - width / 2 - 1, p3.y - ascent / 2, width + 2, ascent
				+ descent);
		g.setColor(foreground);
		g.drawString(label, p3.x - width / 2, p3.y + ascent / 2);
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
