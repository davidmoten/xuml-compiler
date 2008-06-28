package moten.david.xuml.model.viewer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.Stately;

public class StateTerminatorComponent extends StateComponent {

	private static int baseSize = 14;
	private static int gap = 3;
	private static int ringWidth = 1;
	private boolean initial;

	public StateTerminatorComponent(Stately state, boolean initial) {
		super(state);
		this.initial = initial;
		int total = baseSize + gap + ringWidth;
		setSize(total, total);
		setBorder(null);
		setBackground(new JPanel().getBackground());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.clearRect(0, 0, getWidth(), getHeight());
		g.fillOval(gap, gap, baseSize - 2, baseSize - 2);
		if (!initial) {
			g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
		}

	}
}
