package xuml.tools.jaxb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.io.IOUtils;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.ClassWithDomain;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.NativeAttribute;
import xuml.metamodel.jaxb.ReferentialAttribute;
import xuml.metamodel.jaxb.Relationship;

public class ClassDiagramGenerator {

	private static Marshaller m = new Marshaller();

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
		for (Class c : system.getClazz()) {
			System.out.println("class="+c.getName());
			s.append("<div id=\"" + c.getName()
					+ "\" class=\"cls draggable\">\n");
			s.append("  <div class=\"attributes\">\n");
			for (JAXBElement<? extends Attribute> attr : c.getAttribute()) {
				System.out.println("attribute=" + attr.getValue().getName());
				List<String> items = new ArrayList<String>();
				for (Identifier id : attr.getValue().getIdentifier())
					items.add(id.getName());
				if (attr.getValue() instanceof NativeAttribute) {
					NativeAttribute a = (NativeAttribute) attr.getValue();
					s.append("    <div class=\"attribute\">" + a.getName()
							+ ": " + a.getType().value() + " ");
					if (!a.isMandatory())
						items.add("O");
				} else {
					ReferentialAttribute r = (ReferentialAttribute) attr
							.getValue();
					items.add(r.getRelationship());
					s.append("<div class=\"attribute\">"
							+ r.getName() + ": ");
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
			s.append("</div>\n");
		}
		for (Relationship r : system.getRelationship()) {
			s.append("<div class=\"relationship\" id=\"" + r.getName()
					+ "\" className1=\"" + r.getClass1().getName()
					+ "\" className2=\"" + r.getClass2().getName()
					+ "\" verbClause1=\"" + r.getClass1().getVerbClause()
					+ "\" verbClause2=\"" + r.getClass2().getVerbClause()
					+ "\" multiplicity1=\""
					+ getAbbreviation(r.getClass1().getMultiplicity())
					+ "\" multiplicity2=\""
					+ getAbbreviation(r.getClass2().getMultiplicity())
					+ "\"></div>\n");
		}
		for (Generalization g : system.getGeneralization())
			for (ClassWithDomain cls : g.getClazz()) {
				s.append("<div class=\"generalization\" id=\"" + cls.getName()
						+ "-" + g.getName() + "\" groupName=\"" + g.getName()
						+ "\" superClassName=\"" + g.getSuperClass().getName()
						+ "\" subClassName=\"" + cls.getName() + "\"></div>\n");
			}
		return s.toString();
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
