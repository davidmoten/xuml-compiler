package moten.david.xuml.model.viewer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Movable implements MouseMotionListener, MouseListener {

	private int xAdjustment;
	private int yAdjustment;

	@Override
	public void mouseDragged(MouseEvent e) {

		int diffX = e.getX() - xAdjustment;
		int diffY = e.getY() - yAdjustment;
		getComponent(e).setLocation(getComponent(e).getX() + diffX,
				getComponent(e).getY() + diffY);
		((Component) e.getSource()).getParent().repaint();
	}

	private Component getComponent(MouseEvent e) {
		return (Component) e.getSource();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		xAdjustment = e.getX();
		yAdjustment = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void makeMovable(Component component) {
		Movable movable = new Movable();
		component.addMouseMotionListener(movable);
		component.addMouseListener(movable);
	}

}
