package moten.david.xuml.model.compiler;

import java.util.HashMap;
import java.util.Map;

public class ClassRegister {

	private Map<String, String> classNameAbbreviations = new HashMap<String, String>();

	public synchronized String registerClass(String pClassName) {
		String className = pClassName;
		if (className.contains("<"))
			className = className.substring(0, className.indexOf("<"));
		String abbreviation = className;
		if (className.contains("."))
			abbreviation = className.substring(className.lastIndexOf(".") + 1);
		abbreviation = getResultantAbbreviation(className, abbreviation);
		classNameAbbreviations.put(className, abbreviation);
		return abbreviation;
	}

	private String getResultantAbbreviation(String className,
			String abbreviation) {
		for (String cls : classNameAbbreviations.keySet()) {
			if (classNameAbbreviations.get(cls).equals(abbreviation)) {
				if (!className.equals(cls)) {
					// don't abbreviate if already registered against another
					// class
					return className;
				}
			}
		}
		return abbreviation;
	}
}
