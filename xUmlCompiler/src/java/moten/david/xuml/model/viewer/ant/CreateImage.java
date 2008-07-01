package moten.david.xuml.model.viewer.ant;

import java.io.File;

import moten.david.xuml.model.util.SystemBase;
import moten.david.xuml.model.viewer.SystemViewer;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class CreateImage extends Task {

	private String imageFile;
	private String systemClass;
	private String viewerFile;
	private boolean failOnError = true;
	private String imageType = "jpg";

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public void execute() throws BuildException {
		if (imageFile == null)
			throw new BuildException("must specify outputDirectory");
		if (systemClass == null)
			throw new BuildException("must specify systemClass");
		File f = new File(imageFile);
		if (!f.exists())
			f.mkdirs();
		try {
			SystemBase system = (SystemBase) Class.forName(systemClass)
					.newInstance();
			SystemViewer viewer = new SystemViewer(system.getSystem(),
					viewerFile);
			viewer.saveImage(imageFile, imageType);
		} catch (Throwable e) {
			if (failOnError)
				throw new BuildException(e);
			else
				log(e.getMessage());
		}
	}

	public String getSystemClass() {
		return systemClass;
	}

	public void setSystemClass(String systemClass) {
		this.systemClass = systemClass;
	}

	public boolean getFailOnError() {
		return failOnError;
	}

	public void setFailOnError(boolean failOnError) {
		this.failOnError = failOnError;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getViewerFile() {
		return viewerFile;
	}

	public void setViewerFile(String viewerFile) {
		this.viewerFile = viewerFile;
	}

}
