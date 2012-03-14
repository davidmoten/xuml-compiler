package xuml.tools.jaxb;

import xuml.metamodel.jaxb.Multiplicity;

public class Util {
	public static String getAbbreviation(Multiplicity m) {
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

	public static String lowerFirst(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String upperFirst(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static String toJavaIdentifier(String name) {

		StringBuilder s = new StringBuilder();
		boolean capitalize = false;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if ((i != 0 && !Character.isJavaIdentifierStart(ch))
					|| !Character.isJavaIdentifierPart(ch)) {
				capitalize = true;
			} else if (capitalize) {
				s.append(Character.toUpperCase(ch));
				capitalize = false;
			} else
				s.append(ch);
		}
		return lowerFirst(s.toString());
	}

	public static String toJavaConstantIdentifier(String name) {
		StringBuilder s = new StringBuilder();
		boolean funnyCharacter = false;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if ((i != 0 && !Character.isJavaIdentifierStart(ch))
					|| !Character.isJavaIdentifierPart(ch)) {
				funnyCharacter = true;
			} else if (funnyCharacter) {
				s.append("_");
				s.append(Character.toUpperCase(ch));
				funnyCharacter = false;
			} else
				s.append(Character.toUpperCase(ch));
		}
		return s.toString();
	}
}
