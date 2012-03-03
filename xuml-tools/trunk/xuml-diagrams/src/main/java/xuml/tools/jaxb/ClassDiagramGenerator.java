package xuml.tools.jaxb;

import java.util.Set;
import java.util.TreeSet;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Domain;
import xuml.metamodel.jaxb.Identifier;
import xuml.metamodel.jaxb.IdentifierAttribute;

public class ClassDiagramGenerator {

	private static Marshaller m = new Marshaller();

	public String generate(Domain domain) {
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
}
