package xuml.tools.jaxb.compiler;

public class Util {
	public static String lowerFirst(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String capFirst(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
