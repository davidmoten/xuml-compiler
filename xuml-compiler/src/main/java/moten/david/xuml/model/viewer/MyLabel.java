package moten.david.xuml.model.viewer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.BreakIterator;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = 8333725690183566182L;

	private static final String FONT_NAME = "monospace";
	private static final int FONT_SIZE = 10;
	private static final int MAX_WIDTH = 100;

	private final String key;

	public MyLabel(String key, String text) {
		super();
		setSize(100, 40);
		setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
		wrapLabelText(this, text);
		// setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.key = key;
		Movable.makeMovable(this);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON2) {
					setText("");
					setSize(0, 0);
					setLocation(-1000, -1000);
				}
			}
		});
	}

	private void wrapLabelText(JLabel label, String text) {
		FontMetrics fm = label.getFontMetrics(label.getFont());
		BreakIterator boundary = BreakIterator.getWordInstance();
		boundary.setText(text);

		StringBuffer trial = new StringBuffer();
		StringBuffer real = new StringBuffer("<html>");

		int numLines = 1;
		int start = boundary.first();
		int maxWidth = 0;
		int trialWidth = 0;
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary
				.next()) {
			String word = text.substring(start, end);
			int beforeTrialWidth = SwingUtilities.computeStringWidth(fm, trial
					.toString());
			trial.append(word);
			trialWidth = SwingUtilities
					.computeStringWidth(fm, trial.toString());
			if (trialWidth > MAX_WIDTH) {
				if (beforeTrialWidth > maxWidth)
					maxWidth = beforeTrialWidth;
				trial = new StringBuffer(word);
				real.append("<br>");
				numLines++;
			}
			real.append(word);
		}
		int lastLineLength = SwingUtilities.computeStringWidth(fm, trial
				.toString());
		if (lastLineLength > maxWidth)
			maxWidth = lastLineLength;
		if (numLines == 1)
			maxWidth = SwingUtilities.computeStringWidth(fm, text);
		real.append("</html>");
		label.setText(real.toString());
		Dimension newSize = new Dimension();
		newSize.height = numLines * fm.getHeight();
		newSize.width = maxWidth + 5;
		label.setSize(newSize);
	}

	public String getKey() {
		return key;
	}
}
