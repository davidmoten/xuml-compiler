package moten.david.util.text;

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

}
