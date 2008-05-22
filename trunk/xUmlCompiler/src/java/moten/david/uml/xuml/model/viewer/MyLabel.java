package moten.david.uml.xuml.model.viewer;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = 8333725690183566182L;

	private static final String FONT_NAME = "monospace";
	private static final int FONT_SIZE = 10;

	private final String key;

	public MyLabel(String key, String label) {
		super("<html><p>" + label + "</p></html>");
		this.key = key;
		Movable.makeMovable(this);
		setSize(100, 40);
		setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));

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

	public String getKey() {
		return key;
	}
}
