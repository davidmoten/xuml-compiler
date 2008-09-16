package moten.david.xuml.model.viewer;

import java.io.File;

import javax.swing.UIManager;

import moten.david.util.io.RelativePath;
import moten.david.xuml.model.util.SystemBase;

import org.apache.log4j.Logger;

import view.View;

public class ViewerUtil {
	private static Logger log = Logger.getLogger(ViewerUtil.class);

	public static SystemViewer view(String directory,
			Class<? extends SystemBase> cls) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			String definitionFilename = directory + File.separator
					+ cls.getSimpleName() + ".systemDefinition";
			final String viewFilename = directory + File.separator
					+ cls.getSimpleName() + ".systemView";
			log.info("definition=" + definitionFilename);
			log.info("view=" + viewFilename);
			SystemBase system = cls.newInstance();
			system.save(definitionFilename);
			View view = SystemViewer.load(viewFilename);
			String relativeDefinitionPath = RelativePath.getRelativePath(
					new File(viewFilename), new File(definitionFilename));
			view.setFile(relativeDefinitionPath);
			SystemViewer viewer = new SystemViewer(system.getSystem(), view);
			viewer.addListener(new FileSaveListener(new File(viewFilename)));
			viewer.showViewer();
			return viewer;
		} catch (Throwable t) {
			throw new Error(t);
		}
	}
}
