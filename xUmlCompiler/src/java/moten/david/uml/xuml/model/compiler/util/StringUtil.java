package moten.david.uml.xuml.model.compiler.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class StringUtil {

	/**
	 * Reads an InputStream completely to return a string
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String readString(InputStream is) throws IOException {
		StringBuffer s = new StringBuffer();
		BufferedInputStream bis = new BufferedInputStream(is);
		int ch;
		while ((ch = bis.read()) != -1) {
			s.append((char) ch);
		}
		bis.close();
		return s.toString();
	}

	public static String readString(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		String s = readString(fis);
		fis.close();
		return s;
	}

	public static void removeCarriageReturns(InputStream is, OutputStream os)
			throws IOException {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			line = line.replace(((char) 13) + "", "");
			os.write(line.getBytes());
			os.write("\n".getBytes());
		}
		br.close();
		isr.close();
	}

	public static String uncapFirst(String s) {
		if (s == null)
			return null;
		String result = s.substring(0, 1).toLowerCase();
		if (s.length() > 1)
			return result + s.substring(1);
		else
			return result;

	}

	public static String getSimpleClassName(String type) {
		int i = type.lastIndexOf('.');
		if (i >= 0)
			return type.substring(i + 1);
		else
			return type;
	}

	public static String getJavaIdentifier(String string) {
		StringBuffer s = new StringBuffer();
		for (char ch : string.toCharArray()) {
			if (s.length() == 0) {
				if (Character.isJavaIdentifierStart(ch))
					s.append(ch);
			} else {
				if (Character.isJavaIdentifierPart(ch))
					s.append(ch);
				else if (Character.isWhitespace(ch))
					s.append('_');
			}
		}
		return s.toString();
	}

}
