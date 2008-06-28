package moten.david.xuml.model.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

import model.Class;
import model.Stately;
import model.ToState;
import model.Transition;
import moten.david.util.swing.ComponentUtil;

public class TransitionLayer extends JPanel {

	private static final long serialVersionUID = -4032657229299492957L;

	private SystemViewer systemViewer;
	private Class cls;

	public TransitionLayer(SystemViewer systemViewer, Class cls) {
		this.systemViewer = systemViewer;
		this.cls = cls;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Set<Point> usedPoints = new HashSet<Point>();
		g.setFont(g.getFont().deriveFont(10f));
		for (Stately stately : cls.getStateMachine().getState()) {
			paintTransitionsTo(g, usedPoints, stately);
		}
		paintTransitionsTo(g, usedPoints, cls.getStateMachine().getFinalState());

	}

	private void paintTransitionsTo(Graphics g, Set<Point> usedPoints,
			Stately stately) {
		Graphics2D g2d = (Graphics2D) g;
		List<Transition> transitions = getTo(stately);
		for (Transition transition : transitions) {
			Stately from = transition.getFromState();
			Component c1 = systemViewer.getStatelyComponents().get(from);
			Component c2 = systemViewer.getStatelyComponents().get(
					transition.getToState());
			Point[] joinPoints = ComponentUtil.getBestJoin(usedPoints, c1, c2);
			Point p1 = joinPoints[0];
			Point p2 = joinPoints[1];
			{
				if (c1 == c2) {
					Point centre = ComponentUtil.getCentre(p1, p2);
					double dist = ComponentUtil.getDistance(centre, p1);
					g2d.drawOval(centre.x - (int) dist * 3 / 2, centre.y
							- (int) dist * 3 / 2, 3 * (int) dist,
							3 * (int) dist);
				} else
					ComponentUtil.drawArrowedLine(g, p1, p2, 30, 7);
			}

			{
				// draw event label centred on the join line, erasing its
				// background
				Point centre = ComponentUtil.getCentre(p1, p2);
				String label = transition.getEvent().getName();
				int width = g.getFontMetrics().stringWidth(label);
				int ascent = g.getFontMetrics().getAscent();
				int descent = g.getFontMetrics().getDescent();
				int labelX = centre.x - width / 2;
				int labelY = centre.y + ascent / 2;
				// check for join to self and push label away
				if (c1 == c2) {
					int x = labelX;
					int y = labelY;
					for (int i : new int[] { -1, 0, 1 }) {
						for (int j : new int[] { -1, 0, 1 }) {
							int xTemp = labelX + i * ascent - c1.getX();
							int yTemp = labelY + j * (ascent + descent)
									- c1.getY();
							if (!c1.contains(new Point(xTemp, yTemp))) {
								x = xTemp;
								y = yTemp;
							}
						}
					}
					labelX = x + c1.getX();
					labelY = y + c1.getY();
				} else {
					Color foreground = g.getColor();
					g.setColor(getBackground());
					g.fillRect(labelX - 1, labelY - ascent, width + 2, ascent
							+ descent);
					g.setColor(foreground);
				}
				g.drawString(label, labelX, labelY);
			}
		}
	}

	public List<Transition> getTo(Stately stately) {
		List<Transition> list = new ArrayList<Transition>();
		if (stately instanceof ToState) {
			ToState to = (ToState) stately;
			for (Transition transition : to.getTransitionFrom())
				list.add(transition);
		} else
			System.out.println(stately.getName() + " not toState");
		return list;
	}

}
