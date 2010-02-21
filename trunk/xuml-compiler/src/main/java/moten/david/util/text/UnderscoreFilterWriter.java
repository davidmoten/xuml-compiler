package moten.david.util.text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * A {@link Writer} that transforms the character stream to upper case and
 * forwards it to another {@link Writer}.
 */
public class UnderscoreFilterWriter extends Writer {

	private final Writer out;
	private boolean started = false;

	public UnderscoreFilterWriter(Writer out) {
		this.out = out;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < len; i++) {
			char ch = cbuf[i + off];
			if (Character.isUpperCase(ch) && started) {
				out.write('_');
				out.write(Character.toLowerCase(ch));
			} else
				out.write(Character.toLowerCase(ch));
			started = true;
		}
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void close() throws IOException {
		out.close();
	}

	/**
	 * converts camelcase to underscored
	 * 
	 * @param s
	 * @return
	 */
	public static String underscore(String s) {
		try {
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(bytes);
			UnderscoreFilterWriter writer = new UnderscoreFilterWriter(out);
			writer.write(s);
			writer.close();
			out.close();
			bytes.close();
			return bytes.toString();
		} catch (IOException e) {
			throw new Error(e);
		}

	}

}