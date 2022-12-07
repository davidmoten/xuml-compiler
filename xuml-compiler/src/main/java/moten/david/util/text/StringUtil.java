package moten.david.util.text;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
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
	    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	    int n;
	    byte[] buffer = new byte[8192];
	    while ((n = is.read(buffer)) != -1) {
	        bytes.write(buffer, 0, n);
	    }
	    return bytes.toString("UTF-8");
	}

	public static String readString(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
            return readString(fis);
		}
	}

	public static void removeCarriageReturns(InputStream is, OutputStream os)
			throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(((char) 13) + "", "");
                os.write(line.getBytes());
                os.write("\n".getBytes());
            }
        }
	}

}
