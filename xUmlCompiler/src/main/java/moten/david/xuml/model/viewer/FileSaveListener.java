package moten.david.xuml.model.viewer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileSaveListener implements SaveListener {

	private static Logger log = Logger.getLogger(FileSaveListener.class);
	private File file;

	public FileSaveListener(File file) {
		this.file = file;
	}

	@Override
	public void save(byte[] bytes) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.close();
			log.info("saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
