package moten.david.util.ecore;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Saves an EObject to a file in XMI format
 * 
 * @author dave
 * 
 */
public class Xmi {

	private static Logger log = Logger.getLogger(Xmi.class);

	public static void save(EObject eObject, String filename) {
		try {
			log.info("saving eobject as xmi to " + filename);
			// Register the XMI resource factory for the extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xmi", new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();

			// set up save options
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			// Create a resource
			Resource resource = resSet.createResource(URI
					.createFileURI(filename));
			resource.getContents().add(eObject);
			resource.save(options);

			// // Now save the content.
			// Map<String, Object> options = new HashMap<String, Object>();
			// // options.put(Resource.OPTION_CIPHER, new
			// AESCipherImpl("12345"));
			// ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			// resource.save(bytes, options);
			// String s = new String(bytes.toByteArray());
			// FileOutputStream fos = new FileOutputStream(filename);
			// fos.write(s.getBytes());
			// fos.close();
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}
