package moten.david.xuml.model.viewer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ZoomPane extends JComponent implements MouseListener,
		MouseMotionListener, Zoomable {

	private static final long serialVersionUID = -3225052950611166149L;
	protected java.awt.Container contentPane;
	private double zoomFactor = 1.0;

	public double getZoomFactor() {
		return zoomFactor;
	}

	public ZoomPane(java.awt.Container contentPane) {
		addMouseListener(this);
		addMouseMotionListener(this);
		this.contentPane = contentPane;
	}

	// draw some text just so we know the glass pane
	// is installed and visible
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// g.drawString("I'm a glass pane", 50, 50);
	}

	// catch all mouse events and redispatch them
	public void mouseMoved(MouseEvent e) {
		translateEvent(e);
	}

	public void mouseDragged(MouseEvent e) {
		translateEvent(e);
	}

	public void mouseClicked(MouseEvent e) {
		translateEvent(e);
	}

	public void mouseEntered(MouseEvent e) {
		translateEvent(e);
	}

	public void mouseExited(MouseEvent e) {
		translateEvent(e);
	}

	public void mousePressed(MouseEvent e) {
		translateEvent(e);
	}

	public void mouseReleased(MouseEvent e) {
		translateEvent(e);
	}

	private void translateEvent(MouseEvent e) {
		e.translatePoint((int) (e.getX() / zoomFactor - e.getX()), (int) (e
				.getY()
				/ zoomFactor - e.getY()));
		doDispatch(e);
	}

	protected Component getRealComponent(Point pt) {
		// get the mouse click point relative to the content pane
		Point containerPoint = SwingUtilities.convertPoint(this, pt,
				contentPane);

		// find the component that under this point
		Component component = SwingUtilities.getDeepestComponentAt(contentPane,
				containerPoint.x, containerPoint.y);
		return component;
	}

	private Component getMouseListeningParent(Component component) {

		if (component instanceof JScrollPane)
			return component;
		if (component.getMouseListeners() == null
				|| component.getMouseListeners().length == 0)
			if (component.getParent() != null)
				if (component.getParent() instanceof Component)
					return getMouseListeningParent(component.getParent());
				else
					return component;
			else
				return component;
		else
			return component;
	}

	protected void doDispatch(MouseEvent e) {

		Component component = getRealComponent(e.getPoint());

		// return if nothing was found
		if (component == null) {
			return;
		}
		component = getMouseListeningParent(component);

		// convert point relative to the target component
		Point componentPoint = SwingUtilities.convertPoint(this, e.getPoint(),
				component);

		// redispatch the event
		component.dispatchEvent(new MouseEvent(component, e.getID(), e
				.getWhen(), e.getModifiers(), componentPoint.x,
				componentPoint.y, e.getClickCount(), e.isPopupTrigger()));
	}

	public static void main(String[] args) {
		// create a frame with some components in it
		JFrame frame = new JFrame("Right Click Test");
		JButton button = new JButton("this is a button");
		JTextField tf = new JTextField("this is a textfield");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(tf);
		frame.getContentPane().add(panel);

		JPopupMenu popup = new JPopupMenu();
		popup.add(new JMenuItem("Dogs"));
		popup.add(new JMenuItem("Cats"));
		popup.add(new JMenuItem("Mass Hysteria"));

		// create the right click glass pane.
		Component rc = new ZoomPane(frame.getContentPane());
		// set as glasspane and make it visible
		frame.setGlassPane(rc);
		rc.setVisible(true);

		// pack and show the frame
		frame.pack();
		frame.setSize(400, 200);
		frame.setVisible(true);
	}

	// utiltity function
	public static void p(String str) {
		System.out.println(str);
	}

	@Override
	public void setZoomFactor(double zoomFactor) {
		this.zoomFactor = zoomFactor;
	}

}

/*
 * Swing Hacks Tips and Tools for Killer GUIs By Joshua Marinacci, Chris Adamson
 * First Edition June 2005 Series: Hacks ISBN: 0-596-00907-0
 * http://www.oreilly.com/catalog/swinghks/
 */
