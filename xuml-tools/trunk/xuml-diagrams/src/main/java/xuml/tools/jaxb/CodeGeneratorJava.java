package xuml.tools.jaxb;

import java.io.File;
import java.io.PrintStream;
import java.util.Map;

import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Relationship;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class CodeGeneratorJava {

	private static String key(Class cls) {
		return cls.getDomain() + "." + cls.getName();
	}

	private static String key(Relationship r) {
		return r.getNumber() + "";
	}

	private static String key(Generalization g) {
		return g.getNumber() + "";
	}

	private static class Lookups {
		Map<String, Class> classesByName = Maps.newHashMap();
		Map<String, Relationship> relationshipsByName = Maps.newHashMap();
		Map<String, Generalization> generalizationsByName = Maps.newHashMap();
	}

	public void generate(PrintStream out, xuml.metamodel.jaxb.System system,
			Map<String, String> domainPackageNames, File destinationDirectory) {
		// create maps for classes, relationships, generalizations
		Lookups lookups = new Lookups();
		for (Class c : system.getClazz())
			lookups.classesByName.put(key(c), c);
		for (Relationship r : system.getRelationship())
			lookups.relationshipsByName.put(key(r), r);
		for (Generalization g : system.getGeneralization())
			lookups.generalizationsByName.put(key(g), g);

		// create behaviour interfaces
		createBehaviourInterfaces(lookups);
		// create classes (impls)
		createImplementations(lookups);
		// create object factory
		createObjectFactory(lookups);
	}

	private void createObjectFactory(Lookups lookups) {
		// TODO Auto-generated method stub

	}

	private void createImplementations(Lookups lookups) {
		// TODO Auto-generated method stub

	}

	private void createBehaviourInterfaces(Lookups lookups) {
		// TODO Auto-generated method stub

	}
}
