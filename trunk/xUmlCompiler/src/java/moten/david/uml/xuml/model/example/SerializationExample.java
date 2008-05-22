package moten.david.uml.xuml.model.example;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import moten.david.uml.xuml.model.example.mellor.Bookstore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class SerializationExample {

	public static void main(String[] args) {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("craft-tracking-system.xmi")
				.getAbsolutePath());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		resource.getContents().add(new Bookstore().getSystem());

		// Save the contents of the resource to the file system.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}
}
