package moten.david.util.derby;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Utility methods for use with Apache Derby database.
 * 
 * @author dave
 * 
 */
public class DerbyUtil {

	public static final String logFilename = "target/db";
	public static final OutputStream DERBY_LOG = getNullOutputStream();
	public static final OutputStream NULL_LOG = getNullOutputStream();

	public static OutputStream getLogOutputStream() {
		try {
			return new FileOutputStream(logFilename);
		} catch (FileNotFoundException e) {
			throw new Error(e);
		}
	}

	public static OutputStream getNullOutputStream() {
		return new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// do nothing
			}
		};
	}

	public static void divertLog() {
		System.setProperty("derby.stream.error.field", DerbyUtil.class
				.getCanonicalName()
				+ ".DERBY_LOG");
	}

	public static void noLog() {
		System.setProperty("derby.stream.error.field", DerbyUtil.class
				.getCanonicalName()
				+ ".NULL_LOG");
	}

}
