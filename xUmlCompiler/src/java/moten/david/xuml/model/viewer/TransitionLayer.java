package moten.david.xuml.model.viewer;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import model.Class;
import model.Stately;
import model.ToState;
import model.Transition;

public class TransitionLayer extends JPanel {

	private SystemViewer systemViewer;
	private Class cls;
	private Map<Point, List<String>> pointStrings = new HashMap<Point, List<String>>();

	public TransitionLayer(SystemViewer systemViewer, Class cls) {
		this.systemViewer = systemViewer;
		this.cls = cls;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		pointStrings.clear();
		g.setFont(g.getFont().deriveFont(10f));
		for (Stately stately : cls.getStateMachine().getState()) {
			paintTransitionsTo(g, stately);
		}
		paintTransitionsTo(g, cls.getStateMachine().getFinalState());
		for (Point p : pointStrings.keySet()) {
			int i = 0;
			for (String line : pointStrings.get(p)) {
				g.drawString(line, p.x + 5, p.y + i
						* g.getFontMetrics().getHeight());
				i++;
			}
		}
	}

	private void paintTransitionsTo(Graphics g, Stately stately) {
		List<Transition> transitions = getTo(stately);
		for (Transition transition : transitions) {
			Stately from = transition.getFromState();
			Point p1 = getCentre(systemViewer.getStatelyComponents().get(from)
					.getBounds());
			Point p2 = getCentre(systemViewer.getStatelyComponents().get(
					stately).getBounds());
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			Point centre = getCentre(p1, p2);
			if (pointStrings.get(centre) == null)
				pointStrings.put(centre, new ArrayList<String>());
			pointStrings.get(centre).add(transition.getEvent().getName());
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

	private static Point getCentre(Rectangle r) {
		Point p = new Point();
		p.x = r.x + r.width / 2;
		p.y = r.y + r.height / 2;
		return p;
	}

	private static Point getCentre(Point p1, Point p2) {
		Point p = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		return p;
	}

}
