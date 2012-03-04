package xuml.tools.jaxb;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

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
			s.append("<div id=\"" + c.getName()
					+ "\" class=\"cls draggable\">\n");
			s.append("  <div class=\"attributes\">\n");
			for (Attribute a : c.getAttribute()) {
				s.append("    <div class=\"attribute\">" + a.getName() + ": "
						+ a.getType().value());
				s.append(getMatchingIdentifiers(c, a.getName()));
				if (!a.isMandatory())
					s.append(" {O}");
				s.append("</div>\n");
			}
			for (Identifier id : c.getIdentifier())
				for (ReferentialAttribute r : id.getReferential())
						s.append("<div class=\"attribute\">"
								+ r.getClazz().getName()
								+ ": {"
								+ r.getRelationshipName()
								+ "}</div");
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

	public String getMatchingIdentifiers(Class c, String attributeName) {
		Set<String> identifiers = new TreeSet<String>();
		for (Identifier id : c.getIdentifier())
			for (NativeAttribute n: id.getNative())
				if (n.getName().equals(attributeName))
					identifiers.add(id.getName());
		StringBuilder sb = new StringBuilder();
		for (String id : identifiers) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append(id);
		}
		if (sb.length() > 0)
			return " {" + sb + "}";
		else
			return "";
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
