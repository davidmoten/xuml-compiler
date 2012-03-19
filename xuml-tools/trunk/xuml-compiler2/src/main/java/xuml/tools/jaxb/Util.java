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

	public static String toClassSimpleName(String name) {
		return upperFirst(toJavaIdentifier(name));
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

	public static String camelCaseToLowerUnderscore(String s) {
		StringBuilder b = new StringBuilder();
		b.append(s.charAt(0));
		boolean underscoreAdded = false;
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '_') {
				if (!underscoreAdded)
					b.append(ch);
				underscoreAdded = true;
			} else if (Character.isUpperCase(ch)) {
				if (!underscoreAdded) {
					b.append("_");
					b.append(ch);
					underscoreAdded = true;
				} else {
					b.append(ch);
				}
			} else {
				b.append(ch);
				underscoreAdded = false;
			}
		}
		return b.toString().toLowerCase();
	}

	public static String toTableName(String className) {
		return camelCaseToLowerUnderscore(className);
	}

	public static String toTableIdName(String className) {
		return toTableName(className) + "_id";
	}

	public static String toColumnName(String attributeName) {
		return camelCaseToLowerUnderscore(attributeName);
	}
}
