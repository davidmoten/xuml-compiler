package moten.david.uml.xuml.model.viewer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

class ZoomablePanel extends JPanel {

	private static final long serialVersionUID = -5679728491491136755L;
	private int zoomPercent = 100;
	private final Set<Component> zoomables = new HashSet<Component>();

	public ZoomablePanel() {
		super(null);
	}

	public Set<Component> getZoomables() {
		return zoomables;
	}

	@Override
	public Component add(Component comp) {
		if (comp instanceof Zoomable)
			zoomables.add(comp);
		return super.add(comp);
	}

	public void setZoomPercent(int factor) {
		this.zoomPercent = factor;
		if (isShowing())
			repaint();
	}

	public int getZoomPercent() {
		return zoomPercent;
	}

	public int zoom(int n) {
		return n * zoomPercent / 100;
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		double d = zoomPercent / 100d;
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(d, d);
		super.paint(g2);
	}
}