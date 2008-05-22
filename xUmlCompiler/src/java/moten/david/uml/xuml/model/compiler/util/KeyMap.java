package moten.david.uml.xuml.model.compiler.util;

import java.util.HashMap;

public class KeyMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 8725427517637397349L;

	@Override
	public String toString() {

		StringBuffer s = new StringBuffer();
		for (String key : keySet()) {
			Object value = get(key);
			s.append(key + "=");
			s.append("[\n" + (value != null ? value.toString() : "null")
					+ "\n]");
		}
		return s.toString();

	}
}
