package moten.david.uml.xuml.model.compiler.util;

import java.io.File;

public class Util {
	public static String getFileSeparator() {
		return java.lang.System.getProperty("file.separator");
	}

	public static String getFileSystemPath(model.Package p) {
		return getFullPath(p, getFileSeparator());
	}

	public static String getFullPath(model.Package p, String delimiter) {
		if (p == null)
			return "";
		else if (p.getParent() == null)
			return p.getName();
		else
			return getFullPath(p.getParent(), delimiter) + delimiter
					+ p.getName();
	}

	public static String getString(boolean mandatory, boolean multiple) {
		if (mandatory && multiple)
			return "MandatoryMultiple";
		else if (mandatory && !multiple)
			return "Mandatory";
		else if (!mandatory && multiple)
			return "OptionalMultiple";
		else
			return "Optional";
	}

	public static String getPackageFromClass(String cls) {
		int i = cls.lastIndexOf(".");
		if (i == -1)
			return "";
		else
			return cls.substring(0, i);
	}

	public static String getSimpleNameFromClass(String cls) {
		int i = cls.lastIndexOf(".");
		if (i == -1)
			return "";
		else
			return cls.substring(i + 1);
	}

	public static void delete(File f) {
		if (!f.exists())
			return;
		boolean deleted;
		if (f.isFile())
			deleted = f.delete();
		else {
			for (File file : f.listFiles())
				delete(file);
			deleted = f.delete();
		}
		if (!deleted)
			throw new Error("could not delete " + f.getAbsolutePath());
	}

}
