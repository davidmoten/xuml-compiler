package moten.david.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {

	public static void get(URL url, OutputStream os) throws IOException {
		InputStream is = url.openStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		int ch;
		while ((ch = bis.read()) != -1)
			bos.write(ch);
		bis.close();
		is.close();
		bos.close();
	}

	public static void get(URL url, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		get(url, fos);
		fos.close();
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException {
		get(
				new URL(
						"http://repo1.maven.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.jar"),
				new File("temp/ant-1.7.0.jar"));

	}
}
