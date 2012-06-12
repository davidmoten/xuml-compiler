package xuml.tools.jaxb.compiler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import miuml.jaxb.Class;
import miuml.jaxb.Perspective;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Util {

	public static String getMultiplicityAbbreviation(Perspective p) {
		if (p.isConditional() && p.isOnePerspective())
			return "0..1";
		else if (!p.isConditional() && p.isOnePerspective())
			return "1";
		else if (p.isConditional() && !p.isOnePerspective())
			return "*";
		else
			return "1..*";
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
			if (ch == '_' || ch == ' ') {
				if (!underscoreAdded)
					b.append('_');
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

	// Class -> (OtherClass+RNum<->FieldName)
	private static Map<String, BiMap<String, String>> referenceFields = new HashMap<String, BiMap<String, String>>();

	public static String toFieldName(Class cls, String viewedClass,
			BigInteger rNum) {
		if (referenceFields.get(cls.getName()) == null) {
			BiMap<String, String> bimap = HashBiMap.create();
			referenceFields.put(cls.getName(), bimap);
		}
		BiMap<String, String> map = referenceFields.get(cls.getName());
		String key = getKey(viewedClass, rNum);
		if (map.get(key) != null)
			return map.get(key);
		else {
			String optimalFieldName = Util.lowerFirst(Util
					.toJavaIdentifier(viewedClass));
			String currentKey = map.inverse().get(optimalFieldName);
			String fieldName;
			if (currentKey == null)
				fieldName = optimalFieldName;
			else
				fieldName = optimalFieldName + "_R" + rNum;
			map.put(key, fieldName);
			return fieldName;
		}
	}

	public static String toColumnName(Class cls, String viewedClass,
			BigInteger rNum) {
		return Util.toColumnName(toFieldName(cls, viewedClass, rNum));
	}

	private static String getKey(String viewedClass, BigInteger rnum) {
		return viewedClass + ".R" + rnum;
	}
}
