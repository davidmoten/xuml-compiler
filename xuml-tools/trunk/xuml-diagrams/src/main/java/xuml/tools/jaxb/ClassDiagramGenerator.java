package xuml.tools.jaxb;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.io.IOUtils;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.ClassWithDomain;
import xuml.metamodel.jaxb.DerivedAttribute;
import xuml.metamodel.jaxb.Event;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.IndependentAttribute;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.Operation;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;

public class ClassDiagramGenerator {

	public String generate(xuml.metamodel.jaxb.System system) {
		try {
			String template = IOUtils.toString(ClassDiagramGenerator.class
					.getResourceAsStream("/class-diagram-template.html"));
			return template.replace("${xuml.divs}", generateDivs(system));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String generateDivs(xuml.metamodel.jaxb.System system) {
		StringBuilder s = new StringBuilder();
		for (Class c : system.getClazz())
			generateClass(s, c);

		for (Relationship r : system.getRelationship())
			generateRelationship(s, r);

		for (Generalization g : system.getGeneralization())
			for (ClassWithDomain cls : g.getClazz()) {
				s.append("<div class=\"generalization\" id=\"" + cls.getName()
						+ "-" + getRelationshipName(g.getNumber())
						+ "\" groupName=\""
						+ getRelationshipName(g.getNumber())
						+ "\" superClassName=\"" + g.getSuperClass().getName()
						+ "\" subClassName=\"" + cls.getName() + "\"></div>\n");
			}
		return s.toString();
	}

	private void generateRelationship(StringBuilder s, Relationship r) {
		s.append("<div class=\"relationship\" id=\""
				+ getRelationshipName(r.getNumber()) + "\" className1=\""
				+ r.getClass1().getName() + "\" className2=\""
				+ r.getClass2().getName() + "\" verbClause1=\""
				+ r.getClass1().getVerbClause() + "\" verbClause2=\""
				+ r.getClass2().getVerbClause() + "\" multiplicity1=\""
				+ getAbbreviation(r.getClass1().getMultiplicity())
				+ "\" multiplicity2=\""
				+ getAbbreviation(r.getClass2().getMultiplicity())
				+ "\"></div>\n");
	}

	private static String getIdentifierName(BigInteger i) {
		if (i.intValue() == 1)
			return "I";
		else
			return "I" + i;
	}

	private static String getRelationshipName(BigInteger n) {
		return "R" + n;
	}

	private void generateClass(StringBuilder s, Class c) {
		System.out.println("class=" + c.getName());
		s.append("<div id=\"" + c.getName() + "\" class=\"cls draggable");
		if (c.getRelationship() != null)
			s.append(" associationClass");
		s.append("\"");
		if (c.getRelationship() != null)
			s.append(" relationshipName=\""
					+ getRelationshipName(c.getRelationship()) + "\" ");
		s.append(">\n");
		s.append("  <div class=\"attributes\">\n");
		for (JAXBElement<? extends Attribute> attr : c.getAttributeBase()) {
			System.out.println("attribute=" + attr.getValue().getName());
			List<String> items = new ArrayList<String>();
			for (Identifier id : attr.getValue().getIdentifier())
				items.add(getIdentifierName(id.getNumber()));
			if (attr.getValue() instanceof IndependentAttribute) {
				IndependentAttribute a = (IndependentAttribute) attr.getValue();
				s.append("    <div class=\"attribute\">" + a.getName() + ": "
						+ a.getType().value() + " ");
				if (!a.isMandatory())
					items.add("O");
			} else if (attr.getValue() instanceof ReferentialAttribute) {
				ReferentialAttribute r = (ReferentialAttribute) attr.getValue();
				items.add(getRelationshipName(r.getRelationship()));
				s.append("<div class=\"attribute\">" + r.getName() + ": ");
			} else if (attr.getValue() instanceof DerivedAttribute) {
				DerivedAttribute d = (DerivedAttribute) attr.getValue();
				s.append("<div class=\"attribute\">" + "/ " + d.getName()
						+ ": " + d.getType().value());
			}
			StringBuilder b = new StringBuilder();
			for (String item : items) {
				if (b.length() > 0)
					b.append(",");
				b.append(item);
			}
			if (b.length() > 0)
				s.append("{" + b + "}");
			s.append("</div>\n");
		}
		s.append("  </div>\n");

		if (!c.getOperation().isEmpty()) {
			s.append("<div class=\"operations\">");
			for (Operation op : c.getOperation()) {
				s.append("<div class=\"operation\">");
				s.append(op.getName() + "()");
				s.append("</div>");
			}
			s.append("</div>");
		}
		if (!c.getEvent().isEmpty()) {
			s.append("<div class=\"events\">");
			for (Event event : c.getEvent()) {
				s.append("<div class=\"event\">");
				s.append(event.getName());
				s.append("</div>");
			}
			s.append("</div>");
		}
		s.append("</div>\n");
	}

	private static String getAbbreviation(Multiplicity m) {
		if (Multiplicity.MANY.equals(m))
			return "*";
		else if (Multiplicity.ONE.equals(m))
			return "1";
		else if (Multiplicity.ZERO_ONE.equals(m))
			return "0..1";
		else if (Multiplicity.ONE_MANY.equals(m))
			return "1..*";
		else if (Multiplicity.ONE.equals(m))
			return "1";
		else
			throw new RuntimeException("unexpected");
	}
}
