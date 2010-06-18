package moten.david.xuml.model.viewer;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class ImageFilter extends FileFilter {

	// Accept all directories and all gif, jpg, tiff, or png files.
	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		return f.getName().toUpperCase().endsWith(".PNG");
	}

	// The description of this filter
	@Override
	public String getDescription() {
		return "PNG files";
	}
}