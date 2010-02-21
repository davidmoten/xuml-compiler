package moten.david.xuml.model.viewer;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AutoResizingLabel extends JScrollPane {

	/**
	 * @param component
	 * @param width
	 * @param height
	 */
	public AutoResizingLabel(String text, Integer width, Integer height) {
		super(getTextComponent(text, width, height));
		if (width > 0)
			setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		if (height > 0)
			setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	private static JComponent getTextComponent(String text, int width,
			int height) {
		JTextArea c = new MyTextArea(text, width, height);
		return c;
	}

	private static class MyTextArea extends JTextArea {

		private final Integer preferredWidth;
		private final Integer preferredHeight;

		public MyTextArea(String text, Integer width, Integer height) {
			preferredWidth = width;
			preferredHeight = height;
			setText(text);
			setSize(100, 300);
		}

		// @Override
		// public Dimension getPreferredSize() {
		// Dimension d = super.getPreferredSize();
		// if (preferredWidth != null)
		// d.width = preferredWidth;
		// if (preferredHeight != null)
		// d.height = preferredHeight;
		// return d;
		// }
		//
		// @Override
		// public Dimension getSize() {
		// Dimension d = super.getSize();
		// if (preferredWidth != null)
		// d.width = preferredWidth;
		// if (preferredHeight != null)
		// d.height = preferredHeight;
		// return d;
		// }

	}

}
