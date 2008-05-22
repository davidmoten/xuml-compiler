package moten.david.uml.xuml.model.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Container extends JPanel {

	public static final String SEPARATOR = "<separator/>";
	public static final String CENTRE = "<centre/>";
	public static final String ITALIC = "<italic/>";
	public static final String BOLD = "<bold/>";
	private static final long serialVersionUID = -7386517478910415174L;
	private static final String FONT_NAME = "monospace";
	private static final int margin = 5;
	private static final int FONT_SIZE = 10;
	private static int xOffset = 50;
	private static int minHeight = 0;

	public Container(Color backgroundColor, boolean hasBorder, String... lines) {
		super();
		setBackground(backgroundColor);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		Component c = null;
		int width = 0;
		int height = 0;
		for (String line : lines) {
			int style = Font.PLAIN;
			boolean isBold = line.contains(BOLD);
			line = line.replace(BOLD, "");
			if (isBold)
				style = Font.BOLD;
			boolean isItalic = line.contains(ITALIC);
			line = line.replace(ITALIC, "");
			if (isItalic)
				style = Font.ITALIC;
			// boolean separator = line.contains("<separator/>");
			// line = line.replace("<separator/>", "");
			boolean centre = line.contains(CENTRE);
			line = line.replace(CENTRE, "");
			boolean isSeparator = line.contains(SEPARATOR);
			if (isSeparator)
				line = "";
			// line = line.replace("<separator/>", "_______________");
			Font font = new Font(FONT_NAME, style, FONT_SIZE);
			FontMetrics metrics = getFontMetrics(font);
			width = Math.max(width, metrics.stringWidth(line));
			if (isSeparator)
				height += 1;
			else
				height += metrics.getHeight();
			JLabel lab = new JLabel(line);
			if (isSeparator) {
				lab.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
						Color.black));
				lab.getBorder();
				lab.setSize(new Dimension(1, 1000));
			}
			lab.setBackground(backgroundColor);
			if (centre)
				lab.setHorizontalAlignment(JLabel.CENTER);
			add(lab);
			lab.setFont(font);
			if (c == null) {
				layout.putConstraint(SpringLayout.NORTH, lab, 0,
						SpringLayout.NORTH, this);
			} else {
				layout.putConstraint(SpringLayout.NORTH, lab, 0,
						SpringLayout.SOUTH, c);
			}
			layout.putConstraint(SpringLayout.WEST, lab, 0, SpringLayout.WEST,
					this);
			layout.putConstraint(SpringLayout.EAST, lab, 0, SpringLayout.EAST,
					this);
			c = lab;
		}
		// layout
		// .putConstraint(SpringLayout.SOUTH, c, 0, SpringLayout.SOUTH,
		// this);
		// setBounds(r.x + xOffset, r.y, size.width, size.height);
		setLocation(xOffset, 20);

		setSize(width + 4 * margin, Math.max(height + 2 * margin, minHeight));
		xOffset += 10;
		if (hasBorder)
			setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
