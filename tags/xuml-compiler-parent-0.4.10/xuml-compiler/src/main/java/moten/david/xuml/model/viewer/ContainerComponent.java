package moten.david.xuml.model.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.border.DropShadowBorder;

public class ContainerComponent extends JPanel {

	public static final String SEPARATOR = "<separator/>";
	public static final String CENTRE = "<centre/>";
	public static final String ITALIC = "<italic/>";
	public static final String BOLD = "<bold/>";
	public static final String ROUNDED_BORDER = "<rounded-border/>";
	private static final long serialVersionUID = -7386517478910415174L;
	private static final String FONT_NAME = "monospace";
	private static final int margin = 5;
	private static final int FONT_SIZE = 10;
	private static int xOffset = 50;
	private static int minHeight = 0;
	private int borderSize = 7;
	private boolean roundedBorder = false;
	private int arcSize = 30;
	private boolean hasBorder;

	public ContainerComponent(Color backgroundColor, boolean hasBorder,
			String... lines) {
		super();
		setBackground(backgroundColor);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		Component c = null;
		int width = 0;
		int height = 0;
		for (String line : lines) {
			int style = Font.PLAIN;
			if (line.contains(ROUNDED_BORDER))
				roundedBorder = true;
			line = line.replace(ROUNDED_BORDER, "");
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
		setLocation(xOffset, 20);

		setSize(width + 4 * margin + borderSize, Math.max(height + 2 * margin,
				minHeight)
				+ borderSize);
		xOffset += 10;

		this.hasBorder = hasBorder;
		if (hasBorder && !roundedBorder) {
			DropShadowBorder border = new DropShadowBorder(Color.BLACK,
					borderSize, 0.5f, borderSize, false, true, true, true);
			setBorder(border);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Insets insets = new Insets(0, 0, 0, 0);
		if (getBorder() != null)
			insets = getBorder().getBorderInsets(this);
		if (hasBorder) {
			if (roundedBorder)
				g.drawRoundRect(insets.left, insets.top, getWidth()
						- insets.left - insets.right - 1, getHeight()
						- insets.bottom - insets.top - 1, arcSize, arcSize);
			else
				g.drawRect(insets.left, insets.top, getWidth() - insets.left
						- insets.right, getHeight() - insets.bottom
						- insets.top);
		}
	}

}
