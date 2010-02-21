package moten.david.xuml.model.viewer;

import java.io.File;
import java.io.IOException;

public class ImageSaveListener implements SaveListener {

	private SystemViewer systemViewer;
	private File file;

	public ImageSaveListener(SystemViewer systemViewer, File file) {
		this.systemViewer = systemViewer;
		this.file = file;
	}

	@Override
	public void save(byte[] bytes) {
		try {
			systemViewer.saveImageFromGui(file);
		} catch (IOException e) {
			throw new Error(e);
		}
	}

}
