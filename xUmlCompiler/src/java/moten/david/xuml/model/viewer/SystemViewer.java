package moten.david.xuml.model.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import model.Package;
import model.System;
import moten.david.xuml.model.example.mellor.Bookstore;

import org.apache.log4j.Logger;

public class SystemViewer extends JPanel {

	private static Logger log = Logger.getLogger(SystemViewer.class);
	private static final String tab = "\t";
	private static final long serialVersionUID = 4180699653224602583L;
	private final List<ClassComponent> components = new ArrayList<ClassComponent>();

	private final System system;
	private Zoomable zoomable;
	private final String settingsFilename;

	public SystemViewer(model.System system, String settingsFilename) {

		this.settingsFilename = settingsFilename;
		setLayout(null);
		setBackground(Color.white);
		for (Package pkg : system.getPackage()) {
			addClasses(pkg);
		}

		Component joinLayer = new JoinLayer(this);
		joinLayer.setLocation(0, 0);
		joinLayer.setSize(10000, 10000);
		add(joinLayer);
		this.system = system;
		createMenu();

	}

	private void createMenu() {
		final JPopupMenu menu = new JPopupMenu();
		JMenuItem m = new JMenuItem("Print...");
		menu.add(m);
		m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		m = new JMenuItem("Size...");
		menu.add(m);
		m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					menu.show((Component) e.getSource(), e.getX(), e.getY());
				}
			}
		});
	}

	private void addClasses(Package pkg) {
		for (model.Class cls : pkg.getClass_()) {
			ClassComponent component = new ClassComponent(cls);
			add(component);
			components.add(component);
		}
		for (Package p : pkg.getSubPackage()) {
			addClasses(p);
		}
	}

	public List<ClassComponent> getClassComponents() {
		return components;
	}

	public ClassComponent getClassComponent(model.Class cls) {
		for (ClassComponent s : getClassComponents()) {
			if (s.getClass_().equals(cls)) {
				return s;
			}
		}
		return null;
	}

	public ClassComponent getClassComponent(String name) {
		for (ClassComponent s : getClassComponents()) {
			if (s.getClass_().getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	public void save(JFrame frame, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		PrintStream out = new PrintStream(fos);
		out.println("!frame" + tab + frame.getLocation().x + tab
				+ frame.getLocation().y + tab + frame.getWidth() + tab
				+ frame.getHeight());
		out.println("!viewer" + tab + this.getPreferredSize().width + tab
				+ this.getPreferredSize().height);
		for (ClassComponent s : getClassComponents()) {
			out.println("!class" + tab + s.getClass_().getName() + tab
					+ s.getX() + tab + s.getY());
			for (MyLabel c : s.getLabels()) {
				out.println("!label" + tab + c.getKey() + tab + c.getX() + tab
						+ c.getY());
			}
		}
		if (zoomable != null)
			out.println("!zoom" + tab + zoomable.getZoomFactor());
		out.close();
		fos.close();
	}

	public void loadFrame(JFrame frame, String filename)
			throws NumberFormatException, IOException {
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] items = line.split(tab);
			if (line.startsWith("!frame")) {
				frame.setLocation(Integer.parseInt(items[1]), Integer
						.parseInt(items[2]));
				frame.setSize(Integer.parseInt(items[3]), Integer
						.parseInt(items[4]));
			}
			if (line.startsWith("!viewer")) {
				setPreferredSize(new Dimension(Integer.parseInt(items[1]),
						Integer.parseInt(items[2])));
			}
			if (line.startsWith("!zoom")) {
				zoomable.setZoomFactor(Double.parseDouble(items[1]));
			}
		}
	}

	public void loadComponents(String filename) throws NumberFormatException,
			IOException {
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] items = line.split(tab);
			if (line.startsWith("!class")) {
				String name = items[1];
				int x = Integer.parseInt(items[2]);
				int y = Integer.parseInt(items[3]);
				for (ClassComponent s : getClassComponents()) {
					if (s.getClass_().getName().equals(name)) {
						s.setLocation(x, y);
					}
				}
			}
		}
	}

	public void loadAttached(String filename) throws IOException {
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] items = line.split(tab);
			if (line.startsWith("!label")) {
				for (ClassComponent component : components)
					for (MyLabel label : component.getLabels()) {
						if (label.getKey().equals(items[1])) {
							label.setLocation(Integer.parseInt(items[2]),
									Integer.parseInt(items[3]));
						}
					}
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		if (zoomable != null)
			g2d.scale(zoomable.getZoomFactor(), zoomable.getZoomFactor());
		super.paint(g);
	}

	public void showViewer() throws NumberFormatException, IOException {
		final Component thisComponent = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final JFrame frame = new JFrame();
					frame.setTitle("Class Diagram");
					frame.setSize(500, 500);
					frame.getContentPane().setLayout(new GridLayout(1, 1));
					JScrollPane scroll = new JScrollPane(thisComponent);
					scroll.setWheelScrollingEnabled(true);
					// setPreferredSize(new Dimension(2000, 2000));
					frame.getContentPane().add(scroll);

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ZoomPane glassPane = new ZoomPane(frame.getContentPane());
					// frame.setGlassPane(glassPane);
					zoomable = glassPane;
					glassPane.setVisible(true);
					frame.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							double factorChange = 1;
							if (e.getKeyChar() == '+')
								factorChange = 1.1;
							else if (e.getKeyChar() == '-')
								factorChange = 1 / 1.1;
							zoomable.setZoomFactor(zoomable.getZoomFactor()
									* factorChange);
							log.info(e.getKeyChar());
							Dimension d = getPreferredSize();
							d = new Dimension((int) (d.width * factorChange),
									(int) (d.height * factorChange));
							// setPreferredSize(d);
							// frame.getContentPane().validate();
							repaint();
						}
					});

					if (new File(settingsFilename).exists()) {
						loadFrame(frame, settingsFilename);
						loadComponents(settingsFilename);
					}
					for (ClassComponent component : components)
						for (Component label : component.getLabels()) {
							add(label);
							setComponentZOrder(label, 0);
						}
					repaint();
					if (new File(settingsFilename).exists())
						loadAttached(settingsFilename);

					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							try {
								save(frame, settingsFilename);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void print() throws PrinterException {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName("SystemViewer");
		pj.setCopies(1);
		PageFormat format = pj.defaultPage();
		if (getPreferredSize().getWidth() > getPreferredSize().getHeight())
			format.setOrientation(PageFormat.LANDSCAPE);
		else
			format.setOrientation(PageFormat.PORTRAIT);

		pj.setPrintable(new Printable() {
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum > 0) {
					return Printable.NO_SUCH_PAGE;
				}
				Graphics2D g2 = (Graphics2D) pg;

				g2.translate(pf.getImageableX(), pf.getImageableY());
				double scale;
				if (getPreferredSize().getHeight() * 1.0
						/ getPreferredSize().getWidth() > pf.getPaper()
						.getImageableHeight()
						* 1.0 / pf.getPaper().getImageableWidth())
					scale = pf.getPaper().getImageableHeight() * 1.0
							/ getPreferredSize().getHeight();
				else
					scale = pf.getPaper().getImageableWidth() * 1.0
							/ getPreferredSize().getWidth();
				g2.scale(scale, scale);
				setDoubleBuffered(false);
				paint(g2);
				setDoubleBuffered(true);
				return Printable.PAGE_EXISTS;
			}
		});
		if (pj.printDialog() == false)
			return;
		pj.print();
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		SystemViewer viewer = new SystemViewer(new Bookstore().getSystem(),
				"src/viewer/Bookstore.ini");
		viewer.showViewer();
	}

	public Zoomable getZoomable() {
		return zoomable;
	}

	public void setZoomable(Zoomable zoomable) {
		this.zoomable = zoomable;
	}

}
