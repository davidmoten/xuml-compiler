package xuml.tools.jaxb;

import java.io.File;
import java.io.PrintStream;
import java.util.Map;

import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.System;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class CodeGeneratorJava {

	private static class Lookups {
		final Map<String, Class> classesByName = Maps.newHashMap();
		final Map<String, Relationship> relationshipsByName = Maps.newHashMap();
		final Map<String, Generalization> generalizationsByName = Maps
				.newHashMap();

		public Lookups(System system) {
			for (Class c : system.getClazz())
				classesByName.put(key(c), c);
			for (Relationship r : system.getRelationship())
				relationshipsByName.put(key(r), r);
			for (Generalization g : system.getGeneralization())
				generalizationsByName.put(key(g), g);
		}

		public static String key(Class cls) {
			return cls.getDomain() + "." + cls.getName();
		}

		public static String key(Relationship r) {
			return r.getNumber() + "";
		}

		public static String key(Generalization g) {
			return g.getNumber() + "";
		}

	}

	public void generate(PrintStream out, xuml.metamodel.jaxb.System system,
			Map<String, String> domainPackageNames, File destination) {
		// create maps for classes, relationships, generalizations
		Lookups lookups = new Lookups(system);

		// create behaviour interfaces
		createBehaviourInterfaces(lookups, destination);
		// create classes (impls)
		createImplementations(lookups, destination);
		// create object factory
		createObjectFactory(lookups, destination);
	}

	private void createObjectFactory(Lookups lookups, File destination) {
		// TODO Auto-generated method stub

	}

	private void createImplementations(Lookups lookups, File destination) {
		// TODO Auto-generated method stub

	}

	private void createBehaviourInterfaces(Lookups lookups, File destination) {
		// TODO Auto-generated method stub

	}
}
