package xuml.tools.jaxb;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Domain;
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.IdentifierAttribute;
import xuml.metamodel.jaxb.Multiplicity;
import xuml.metamodel.jaxb.Relationship;

public class ClassDiagramGenerator {

	private static Marshaller m = new Marshaller();

	public String generate(Domain domain) {
		try {
			String template = IOUtils.toString(ClassDiagramGenerator.class
					.getResourceAsStream("/class-diagram-template.html"));
			return template.replace("${xuml.divs}", generateDivs(domain));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String generateDivs(Domain domain) {
		StringBuilder s = new StringBuilder();
		for (Class c : domain.getClazz()) {
			s.append("<div id=\"" + c.getName()
					+ "\" class=\"cls draggable\">\n");
			s.append("  <div class=\"attributes\">\n");
			for (Attribute a : c.getAttribute()) {
				s.append("    <div class=\"attribute\">" + a.getName() + ": "
						+ a.getType().value());
				s.append(getMatchingIdentifiers(c, null, a.getName()));
				if (!a.isMandatory())
					s.append(" {O}");
				s.append("</div>\n");
			}
			for (Identifier id : c.getIdentifier())
				for (IdentifierAttribute ida : id.getAttribute())
					if (ida.getRelationshipName() != null)
						s.append("<div class=\"attribute\">" + ida.getName()
								+ " " + ida.getRelationshipName() + "</div");
			s.append("  </div>\n");
			s.append("</div>\n");
		}
		for (Relationship r : domain.getRelationship()) {
			s.append("<div class=\"relationship\" id=\"" + r.getName()
					+ "\" className1=\"" + r.getClassName1()
					+ "\" className2=\"" + r.getClassName2()
					+ "\" verbClause1=\"" + r.getVerbClause1()
					+ "\" verbClause2=\"" + r.getVerbClause2()
					+ "\" multiplicity1=\""
					+ getAbbreviation(r.getMultiplicity1())
					+ "\" multiplicity2=\""
					+ getAbbreviation(r.getMultiplicity2()) + "\"></div>");
		}
		return s.toString();
	}

	public String getMatchingIdentifiers(Class c, String relationshipName,
			String attributeName) {
		Set<String> identifiers = new TreeSet<String>();
		for (Identifier id : c.getIdentifier())
			for (IdentifierAttribute ida : id.getAttribute())
				if (ida.getName().equals(attributeName)
						&& ida.getRelationshipName() == relationshipName)
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
