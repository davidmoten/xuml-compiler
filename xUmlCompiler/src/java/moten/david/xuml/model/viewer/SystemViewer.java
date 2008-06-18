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
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import model.Package;
import moten.david.xuml.model.example.mellor.Bookstore;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import view.Element;
import view.Frame;
import view.View;
import view.ViewFactory;
import view.Viewport;

public class SystemViewer extends JPanel {

	private static final String SETTINGS_EXTENSION = "ecore";
	private static Logger log = Logger.getLogger(SystemViewer.class);
	private static final String tab = "\t";
	private static final long serialVersionUID = 4180699653224602583L;
	private final List<ClassComponent> components = new ArrayList<ClassComponent>();

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
		createMenu();
	}

	private Element getElement(View view, ClassComponent c) {
		for (Element e : view.getElement()) {
			if (getElementName(c).equals(e.getName()))
				return e;
		}
		return null;
	}

	private Element getElement(View view, MyLabel label) {
		for (Element e : view.getElement()) {
			if (getElementName(label).equals(e.getName()))
				return e;
		}
		return null;
	}

	private String getElementName(ClassComponent c) {
		return "class." + c.getClass_().getName();
	}

	private String getElementName(MyLabel label) {
		return "label." + label.getKey();
	}

	public void save(JFrame frame) {
		View view = ViewFactory.eINSTANCE.createView();
		for (ClassComponent c : components) {
			Element element = ViewFactory.eINSTANCE.createElement();
			element.setX(c.getX());
			element.setY(c.getY());
			element.setName(getElementName(c));
			view.getElement().add(element);
			for (MyLabel label : c.getLabels()) {
				Element e = ViewFactory.eINSTANCE.createElement();
				e.setX(label.getX());
				e.setY(label.getY());
				e.setName(getElementName(label));
				e.setFixedTo(element);
				view.getElement().add(e);
			}
		}
		Frame f = ViewFactory.eINSTANCE.createFrame();
		f.setX(frame.getX());
		f.setY(frame.getY());
		f.setHeight(frame.getHeight());
		f.setWidth(frame.getWidth());
		Viewport v = ViewFactory.eINSTANCE.createViewport();
		v.setHeight(getPreferredSize().height);
		v.setWidth(getPreferredSize().width);
		view.setFrame(f);
		view.setViewport(v);
		save(view);
		// View view2 = load();
		// log.info("saved, loaded");
	}

	private void save(View view) {
		try {
			String filename = settingsFilename;
			// Register the XMI resource factory for the extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;

			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put(SETTINGS_EXTENSION, new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();

			// set up save options
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			// Create a resource
			Resource resource = resSet.createResource(URI.createURI(filename));
			resource.getContents().add(view);
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();

			resource.save(bytes, options);
			String s = bytes.toString();
			String xmlns = "xmlns:model=\"http://davidmoten.homeip.net/uml/executable/model\"";
			String schemaLocation = "xsi:schemaLocation=\"http://davidmoten.homeip.net/uml/executable/model http://xuml-compiler.googlecode.com/svn/trunk/xUmlMetaModel/model/uml.ecore\"";
			s = s.replace(xmlns, xmlns + " " + schemaLocation);
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(s.getBytes());
			fos.close();
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public View load() {
		try {
			String filename = settingsFilename;
			// Register the XMI resource factory for the extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put(SETTINGS_EXTENSION, new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resourceSet = new ResourceSetImpl();

			{
				// perform some trickery to get the ViewPackage to be loaded
				// this is a workaround for an ecore problem
				View temp = ViewFactory.eINSTANCE.createView();
				Resource resource = new ResourceSetImpl().createResource(URI
						.createURI("unused." + SETTINGS_EXTENSION));
				resource.getContents().add(temp);
				resource.getContents().remove(temp);
			}
			log.info(ViewFactory.eINSTANCE.getViewPackage());
			resourceSet.getPackageRegistry().put(
					ViewFactory.eINSTANCE.getViewPackage().getNsURI(),
					ViewFactory.eINSTANCE.getViewPackage());

			// Get the resource
			Resource resource = resourceSet.getResource(
					URI.createURI(filename), true);

			View view = (View) resource.getContents().get(0);
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void locateRandomly(Component c) {
		c.setLocation((int) Math.round(100 * Math.random()), (int) Math
				.round(100 * Math.random()));
	}

	private void applyView(View view, JFrame frame) {
		for (ClassComponent c : components) {
			Element element = getElement(view, c);
			if (element == null)
				locateRandomly(c);
			else {
				c.setLocation(element.getX(), element.getY());
				for (MyLabel label : c.getLabels()) {
					Element e = getElement(view, label);
					if (e == null)
						locateRandomly(label);
					else {
						label.setLocation(e.getX(), e.getY());
					}
				}
			}
		}
		frame.setLocation(view.getFrame().getX(), view.getFrame().getY());
		frame.setSize(new Dimension(view.getFrame().getWidth(), view.getFrame()
				.getHeight()));
		setPreferredSize(new Dimension(view.getViewport().getWidth(), view
				.getViewport().getHeight()));
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

	// public void save(JFrame frame, String filename) throws IOException {
	// FileOutputStream fos = new FileOutputStream(filename);
	// PrintStream out = new PrintStream(fos);
	// out.println("!frame" + tab + frame.getLocation().x + tab
	// + frame.getLocation().y + tab + frame.getWidth() + tab
	// + frame.getHeight());
	// out.println("!viewer" + tab + this.getPreferredSize().width + tab
	// + this.getPreferredSize().height);
	// for (ClassComponent s : getClassComponents()) {
	// out.println("!class" + tab + s.getClass_().getName() + tab
	// + s.getX() + tab + s.getY());
	// for (MyLabel c : s.getLabels()) {
	// out.println("!label" + tab + c.getKey() + tab + c.getX() + tab
	// + c.getY());
	// }
	// }
	// if (zoomable != null)
	// out.println("!zoom" + tab + zoomable.getZoomFactor());
	// out.close();
	// fos.close();
	// save(frame);
	// }

	// public void loadFrame(JFrame frame, String filename)
	// throws NumberFormatException, IOException {
	// FileInputStream fis = new FileInputStream(filename);
	// InputStreamReader isr = new InputStreamReader(fis);
	// BufferedReader br = new BufferedReader(isr);
	// String line;
	// while ((line = br.readLine()) != null) {
	// String[] items = line.split(tab);
	// if (line.startsWith("!frame")) {
	// frame.setLocation(Integer.parseInt(items[1]), Integer
	// .parseInt(items[2]));
	// frame.setSize(Integer.parseInt(items[3]), Integer
	// .parseInt(items[4]));
	// }
	// if (line.startsWith("!viewer")) {
	// setPreferredSize(new Dimension(Integer.parseInt(items[1]),
	// Integer.parseInt(items[2])));
	// }
	// if (line.startsWith("!zoom")) {
	// zoomable.setZoomFactor(Double.parseDouble(items[1]));
	// }
	// }
	// }
	//
	// public void loadComponents(String filename) throws NumberFormatException,
	// IOException {
	// FileInputStream fis = new FileInputStream(filename);
	// InputStreamReader isr = new InputStreamReader(fis);
	// BufferedReader br = new BufferedReader(isr);
	// String line;
	// while ((line = br.readLine()) != null) {
	// String[] items = line.split(tab);
	// if (line.startsWith("!class")) {
	// String name = items[1];
	// int x = Integer.parseInt(items[2]);
	// int y = Integer.parseInt(items[3]);
	// for (ClassComponent s : getClassComponents()) {
	// if (s.getClass_().getName().equals(name)) {
	// s.setLocation(x, y);
	// }
	// }
	// }
	// }
	// }
	//
	// public void loadAttached(String filename) throws IOException {
	// FileInputStream fis = new FileInputStream(filename);
	// InputStreamReader isr = new InputStreamReader(fis);
	// BufferedReader br = new BufferedReader(isr);
	// String line;
	// while ((line = br.readLine()) != null) {
	// String[] items = line.split(tab);
	// if (line.startsWith("!label")) {
	// for (ClassComponent component : components)
	// for (MyLabel label : component.getLabels()) {
	// if (label.getKey().equals(items[1])) {
	// label.setLocation(Integer.parseInt(items[2]),
	// Integer.parseInt(items[3]));
	// }
	// }
	// }
	// }
	// }

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
					frame.addKeyListener(createKeyListener());

					for (ClassComponent component : components)
						for (Component label : component.getLabels()) {
							add(label);
							setComponentZOrder(label, 0);
						}
					// if (!new File(settingsFilename + ".ecore").exists()) {
					// if (new File(settingsFilename).exists()) {
					// loadFrame(frame, settingsFilename);
					// loadComponents(settingsFilename);
					// }
					// if (new File(settingsFilename).exists())
					// loadAttached(settingsFilename);
					// } else {
					View view2 = load();
					applyView(view2, frame);
					// }
					repaint();
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							try {
								save(frame);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});

					frame.setVisible(true);

					repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private KeyListener createKeyListener() {
		return new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				double factorChange = 1;
				if (e.getKeyChar() == '+')
					factorChange = 1.1;
				else if (e.getKeyChar() == '-')
					factorChange = 1 / 1.1;
				zoomable.setZoomFactor(zoomable.getZoomFactor() * factorChange);
				log.info(e.getKeyChar());
				Dimension d = getPreferredSize();
				d = new Dimension((int) (d.width * factorChange),
						(int) (d.height * factorChange));
				// setPreferredSize(d);
				// frame.getContentPane().validate();
				repaint();
			}
		};
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
