package xuml.tools.jaxb.compiler;

import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class TypeRegister {

	/**
	 * Full type name -> abbr (if possible)
	 */
	private final BiMap<String, String> types = HashBiMap.create();

	public String addType(Type type) {
		StringBuilder result = new StringBuilder(addType(type.getBase()));
		StringBuilder typeParams = new StringBuilder();
		for (Type t : type.getGenerics()) {
			String typeParameter = addType(t);
			if (typeParams.length() > 0)
				typeParams.append(",");
			typeParams.append(typeParameter);
		}
		if (typeParams.length() > 0) {
			result.append("<");
			result.append(typeParams);
			result.append(">");
		}
		return result.toString();
	}

	String addType(String type) {
		String abbr = types.get(type);
		if (abbr != null)
			return abbr;
		else {
			int i = type.lastIndexOf(".");
			if (i >= 0) {
				String last = type.substring(i + 1);
				if (types.inverse().get(last) != null)
					return type;
				else {
					types.put(type, last);
					return last;
				}
			} else
				return type;
		}
	}

	public Set<String> getImports() {
		return new TreeSet<String>(types.keySet());
	}
}