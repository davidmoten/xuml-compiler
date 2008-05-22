package moten.david.uml.xuml.model.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Association;
import model.AssociationEnd;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeDerived;
import model.Event;
import model.IdentifierNonPrimary;
import model.Operation;
import model.Parameter;
import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.compiler.util.StringUtil;
import moten.david.uml.xuml.model.util.ModelUtil;

public class ClassComponent extends Container {

	private static final long serialVersionUID = -1185107452366560789L;
	private final model.Class cls;
	private Set<MyLabel> labels;

	public ClassComponent(model.Class cls) {
		super(Color.white, true, getLines(cls).toArray(new String[] {}));
		this.cls = cls;
		Movable.makeMovable(this);
		MyMovable movable = new MyMovable();
		addMouseListener(movable);
		addMouseMotionListener(movable);
		setDoubleBuffered(false);
	}

	public static List<String> getLines(model.Class cls) {
		List<String> lines = new ArrayList<String>();
		if (cls.getPersistence() == null) {
			lines.add("<<DataType>>" + Container.CENTRE);
		}
		lines.add(cls.getName() + Container.BOLD + Container.CENTRE);
		lines.add(Container.SEPARATOR);
		for (Attribute a : cls.getAttribute()) {
			String line = "  " + a.getName() + ":  " + a.getType().getName()
					+ " ";
			if (!a.isMandatory())
				line = line + "{O}";
			if (a.isUnique())
				line = line + "{U}";
			if (cls.getIdentifierPrimary().getAttribute().contains(a)) {
				line = line + "{" + cls.getIdentifierPrimary().getName() + "}";
			}
			for (IdentifierNonPrimary i : cls.getIdentifierNonPrimary()) {
				if (i.getAttribute().contains(a)) {
					line = line + "{" + i.getName() + "}";
				}
			}

			lines.add(line);
		}
		for (AttributeDerived a : cls.getAttributeDerived()) {
			Association association = getAssociation(a.getAssociationEnd());
			String line = "  " + a.getAssociationEnd().getRole() + " {"
					+ association.getName() + "} ";
			if (cls.getIdentifierPrimary().getDerivedAttribute().contains(a)) {
				line = line + "{" + cls.getIdentifierPrimary().getName() + "}";
			}
			for (IdentifierNonPrimary i : cls.getIdentifierNonPrimary()) {
				if (i.getDerivedAttribute().contains(a)) {
					line = line + "{" + i.getName() + "}";
				}
			}
			lines.add(line);
		}
		if (cls.getOperation().size() > 0)
			lines.add(Container.SEPARATOR);
		for (Operation o : cls.getOperation()) {
			StringBuffer s = new StringBuffer();
			s.append(o.getName() + "(");
			StringBuffer params = new StringBuffer();
			for (Parameter p : o.getParameter()) {
				if (params.length() > 0)
					params.append(",");
				params.append(p.getName()
						+ ":"
						+ StringUtil.getSimpleClassName(ModelUtil.getTypeName(p
								.getType())));
				if (p.isMultiple())
					params.append("[]");
			}
			s.append(params + ")");
			if (o.getReturns() != null) {
				s.append(":"
						+ StringUtil.getSimpleClassName(ModelUtil.getTypeName(o
								.getReturns())));
				if (o.isReturnsMultiple())
					s.append("[]");
			}
			lines.add(" " + s.toString());
		}
		if (cls.getStateMachine() != null) {
			if (cls.getStateMachine().getEvent().size() > 0)
				lines.add(Container.SEPARATOR);
			for (Event event : cls.getStateMachine().getEvent()) {
				lines.add("  " + event.getName() + Container.ITALIC);
			}
		}
		return lines;
	}

	private static Association getAssociation(AssociationEnd associationEnd) {
		if (associationEnd instanceof model.AssociationEndPrimary) {
			return ((AssociationEndPrimary) associationEnd).getAssociation();
		} else
			return ((AssociationEndSecondary) associationEnd).getAssociation();
	}

	public model.Class getClass_() {
		return cls;
	}

	public Set<MyLabel> getLabels() {
		if (labels == null) {
			labels = new HashSet<MyLabel>();
			String suffix = "";
			for (AssociationEndPrimary ae : cls.getAssociationEndPrimary()) {
				if (ae.getClass_().equals(
						ae.getAssociation().getSecondary().getClass_())) {
					suffix = " Primary";
				}
				String key = getVerbClauseKey(ae.getAssociation()) + suffix;
				createLabel(key, ae.getVerbClause(), ae.getAssociation()
						.getName()
						+ suffix);
				key = getMultiplicityKey(ae.getAssociation()) + suffix;
				createLabel(key, Multiplicity.getMultiplicity(ae.isMandatory(),
						ae.isMultiple()), ae.getAssociation().getName()
						+ suffix);
			}
			suffix = "";
			for (AssociationEndSecondary ae : cls.getAssociationEndSecondary()) {
				if (ae.getClass_().equals(
						ae.getAssociation().getPrimary().getClass_())) {
					suffix = " Secondary";
				}
				String key = getVerbClauseKey(ae.getAssociation()) + suffix;
				createLabel(key, ae.getVerbClause(), ae.getAssociation()
						.getName()
						+ suffix);
				key = getMultiplicityKey(ae.getAssociation()) + suffix;
				createLabel(key, Multiplicity.getMultiplicity(ae.isMandatory(),
						ae.isMultiple()), ae.getAssociation().getName()
						+ suffix);
			}
		}
		return labels;
	}

	private String getVerbClauseKey(Association a) {
		return "Class " + cls.getName() + " Association " + a.getName()
				+ " Verb Clause";
	}

	private String getMultiplicityKey(Association a) {
		return "Class " + cls.getName() + " Association " + a.getName()
				+ " Multiplicity";
	}

	private void createLabel(String key, String s, String toolTip) {
		MyLabel label = new MyLabel(key, s);
		label.setToolTipText(cls.getName() + " " + toolTip);
		labels.add(label);
		label
				.setLocation(getX() + getWidth() + 10, getY() + labels.size()
						* 20);
	}

	private class MyMovable implements MouseMotionListener, MouseListener {

		private int xAdjustment;
		private int yAdjustment;

		@Override
		public void mouseDragged(MouseEvent e) {

			int diffX = e.getX() - xAdjustment;
			int diffY = e.getY() - yAdjustment;
			for (Component c : getLabels()) {
				c.setLocation(c.getLocation().x + diffX, c.getLocation().y
						+ diffY);
				c.repaint();
			}

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

	}

}
