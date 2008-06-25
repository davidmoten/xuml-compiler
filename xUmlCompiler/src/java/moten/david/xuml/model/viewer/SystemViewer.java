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
import java.awt.event.WindowListener;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.FinalState;
import model.InitialState;
import model.Package;
import model.State;
import model.Stately;
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

public class SystemViewer {

	private static final String URL_VIEWER_ECORE = "http://xuml-compiler.googlecode.com/svn/trunk/xUmlCompiler/src/viewer/model/viewer.ecore";
	private static final String VIEW_PACKAGE_NAMESPACE_URI = "http://davidmoten.homeip.net/uml/executable/view";
	private static final String SETTINGS_EXTENSION = "ecore";
	private static Logger log = Logger.getLogger(SystemViewer.class);
	private static final long serialVersionUID = 4180699653224602583L;
	private final List<ClassComponent> components = new ArrayList<ClassComponent>();

	private Zoomable zoomable;
	private final String settingsFilename;
	private final JPanel systemPanel = new SystemPanel();
	private final Map<model.Class, JPanel> stateMachinePanels = new HashMap<model.Class, JPanel>();
	private final Map<Stately, StateComponent> statelyComponents = new HashMap<Stately, StateComponent>();

	private enum DiagramType {
		CLASS_DIAGRAM, STATE_MACHINE_DIAGRAM
	}

	public SystemViewer(model.System system, String settingsFilename) {
		systemPanel.setLayout(null);
		systemPanel.setBackground(Color.white);
		this.settingsFilename = settingsFilename;
		createComponents(system);
		Component joinLayer = new JoinLayer(this);
		joinLayer.setLocation(0, 0);
		joinLayer.setSize(10000, 10000);
		systemPanel.add(joinLayer);
		createMenu();
	}

	private void createComponents(model.System system) {
		for (Package pkg : system.getPackage()) {
			addClasses(pkg);
		}
		for (ClassComponent component : components)
			for (Component label : component.getLabels()) {
				systemPanel.add(label);
				systemPanel.setComponentZOrder(label, 0);
			}
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

	private Element getElement(View view, StateComponent c) {
		for (Element e : view.getElement()) {
			if (getElementName(c).equals(e.getName()))
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

	private String getElementName(StateComponent c) {
		String className = null;
		if (c.getStately() instanceof InitialState)
			className = ((InitialState) c.getStately()).getStateMachine()
					.getClass_().getName();
		else if (c.getStately() instanceof FinalState)
			className = ((FinalState) c.getStately()).getStateMachine()
					.getClass_().getName();
		else if (c.getStately() instanceof State)
			className = ((State) c.getStately()).getStateMachine().getClass_()
					.getName();

		return "class." + className + ".state." + c.getStately().getName();
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

		for (Stately stately : statelyComponents.keySet()) {
			Element element = ViewFactory.eINSTANCE.createElement();
			StateComponent c = statelyComponents.get(stately);
			element.setX(c.getX());
			element.setY(c.getY());
			element.setName(getElementName(c));
			view.getElement().add(element);
		}

		Frame f = ViewFactory.eINSTANCE.createFrame();
		f.setX(frame.getX());
		f.setY(frame.getY());
		f.setHeight(frame.getHeight());
		f.setWidth(frame.getWidth());
		Viewport v = ViewFactory.eINSTANCE.createViewport();
		v.setHeight(systemPanel.getPreferredSize().height);
		v.setWidth(systemPanel.getPreferredSize().width);
		view.setFrame(f);
		view.setViewport(v);
		save(view);
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
			final String xmlns = "xmlns:view=\"http://davidmoten.homeip.net/uml/executable/view\"";
			final String schemaLocation = "xsi:schemaLocation=\""
					+ VIEW_PACKAGE_NAMESPACE_URI + " " + URL_VIEWER_ECORE
					+ "\"";
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
				// this is a workaround for an ecore instantiation problem
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
		for (StateComponent c : statelyComponents.values()) {
			locateRandomly(c);
		}
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
		for (Stately stately : statelyComponents.keySet()) {
			StateComponent c = statelyComponents.get(stately);
			Element element = getElement(view, c);
			if (element == null)
				locateRandomly(c);
			else {
				c.setLocation(element.getX(), element.getY());
			}
		}
		frame.setLocation(view.getFrame().getX(), view.getFrame().getY());
		frame.setSize(new Dimension(view.getFrame().getWidth(), view.getFrame()
				.getHeight()));
		systemPanel.setPreferredSize(new Dimension(view.getViewport()
				.getWidth(), view.getViewport().getHeight()));
	}

	private void createMenu() {
		final JPopupMenu menu = new JPopupMenu();
		JMenuItem m = new JMenuItem("Print...");
		menu.add(m);
		m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					print(systemPanel);
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
		systemPanel.addMouseListener(new MouseAdapter() {
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
			systemPanel.add(component);
			components.add(component);
			if (cls.getStateMachine() != null) {
				JPanel panel = new JPanel();
				// panel.setBackground(Color.white);
				panel.setLayout(null);
				for (State state : cls.getStateMachine().getState())
					createStatelyComponent(state, panel);
				createStatelyComponent(cls.getStateMachine().getInitialState(),
						panel);
				createStatelyComponent(cls.getStateMachine().getFinalState(),
						panel);
				stateMachinePanels.put(cls, panel);
				Component transitions = new TransitionLayer(this, cls);
				transitions.setLocation(0, 0);
				transitions.setSize(10000, 10000);
				panel.add(transitions);
			}
		}
		for (Package p : pkg.getSubPackage()) {
			addClasses(p);
		}
	}

	private void createStatelyComponent(Stately state, JPanel panel) {
		if (state == null)
			return;
		StateComponent c = new StateComponent(state);
		panel.add(c);
		statelyComponents.put(state, c);
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

	public class SystemPanel extends JPanel {

		private static final long serialVersionUID = -2781923961274800777L;

		@Override
		public void paint(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;
			if (zoomable != null)
				g2d.scale(zoomable.getZoomFactor(), zoomable.getZoomFactor());
			super.paint(g);
		}
	}

	public void showViewer() throws NumberFormatException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final JFrame frame = new JFrame();
					frame.setTitle("xUmlCompiler");
					frame.setSize(500, 500);
					frame.getContentPane().setLayout(new GridLayout(1, 1));
					frame.setIconImage(new ImageIcon(SystemViewer.class
							.getResource("viewer.gif")).getImage());
					JTabbedPane tabs = new JTabbedPane();
					JScrollPane scroll = new JScrollPane(systemPanel);
					scroll.setWheelScrollingEnabled(true);
					tabs.add("Class Diagram", scroll);
					for (model.Class cls : stateMachinePanels.keySet()) {
						tabs.add(cls.getName(), new JScrollPane(
								stateMachinePanels.get(cls)));
					}

					// setPreferredSize(new Dimension(2000, 2000));
					frame.getContentPane().add(tabs);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					ZoomPane glassPane = new ZoomPane(frame.getContentPane());
					// frame.setGlassPane(glassPane);
					zoomable = glassPane;
					glassPane.setVisible(true);

					frame.addKeyListener(createKeyListener());
					View view = load();
					applyView(view, frame);
					frame.addWindowListener(createWindowListener(frame));
					frame.setVisible(true);
					frame.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private WindowListener createWindowListener(final JFrame frame) {
				return new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						try {
							save(frame);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				};
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
				Dimension d = systemPanel.getPreferredSize();
				d = new Dimension((int) (d.width * factorChange),
						(int) (d.height * factorChange));
				// setPreferredSize(d);
				// frame.getContentPane().validate();
				systemPanel.repaint();
			}
		};
	}

	private void print(final JPanel panel) throws PrinterException {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName("SystemViewer");
		pj.setCopies(1);
		PageFormat format = pj.defaultPage();
		if (panel.getPreferredSize().getWidth() > panel.getPreferredSize()
				.getHeight())
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
				if (panel.getPreferredSize().getHeight() * 1.0
						/ panel.getPreferredSize().getWidth() > pf.getPaper()
						.getImageableHeight()
						* 1.0 / pf.getPaper().getImageableWidth())
					scale = pf.getPaper().getImageableHeight() * 1.0
							/ panel.getPreferredSize().getHeight();
				else
					scale = pf.getPaper().getImageableWidth() * 1.0
							/ systemPanel.getPreferredSize().getWidth();
				g2.scale(scale, scale);
				systemPanel.setDoubleBuffered(false);
				systemPanel.paint(g2);
				systemPanel.setDoubleBuffered(true);
				return Printable.PAGE_EXISTS;
			}
		});
		if (pj.printDialog() == false)
			return;
		pj.print();
	}

	public Zoomable getZoomable() {
		return zoomable;
	}

	public void setZoomable(Zoomable zoomable) {
		this.zoomable = zoomable;
	}

	public Map<Stately, StateComponent> getStatelyComponents() {
		return statelyComponents;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		SystemViewer viewer = new SystemViewer(new Bookstore().getSystem(),
				"src/viewer/Bookstore.ecore");
		viewer.showViewer();
	}

}
