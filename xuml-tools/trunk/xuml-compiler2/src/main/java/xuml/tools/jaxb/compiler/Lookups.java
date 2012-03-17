package xuml.tools.jaxb.compiler;

import java.math.BigInteger;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import xuml.metamodel.jaxb.Association;
import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.System;

import com.google.common.collect.Maps;

class Lookups {
	private final Map<String, Class> classesByName = Maps.newHashMap();
	private final Map<String, Relationship> relationshipsByName = Maps
			.newHashMap();

	private final Map<String, Attribute> attributesByName = Maps.newHashMap();
	private final System system;

	public Lookups(System system) {
		this.system = system;
		for (Class c : system.getClazz()) {
			classesByName.put(key(c), c);
			for (JAXBElement<? extends Attribute> a : c.getAttributeBase()) {
				attributesByName.put(
						attributeKey(c.getDomain(), c.getName(), a.getValue()
								.getName()), a.getValue());
			}
		}

		for (JAXBElement<? extends Relationship> r : system
				.getRelationshipBase())
			relationshipsByName.put(key(r.getValue()), r.getValue());
		java.lang.System.out.println(relationshipsByName.toString().replaceAll(
				",", ",\n"));
	}

	public System getSystem() {
		return system;
	}

	private static String attributeKey(String domain, String className,
			String attribute) {
		return domain + "." + className + "." + attribute;
	}

	private static String key(Class cls) {
		return key(cls.getDomain(), cls.getName());
	}

	private static String key(String domain, String name) {
		return domain + "." + name;
	}

	private static String key(Relationship r) {
		return relationshipKey(r.getDomain(), r.getNumber());
	}

	private static String relationshipKey(String domain, BigInteger number) {
		return domain + "._relationship_." + number;
	}

	public Class getClass(String domain, String name) {
		return classesByName.get(key(domain, name));
	}

	public Attribute getAttribute(String domain, String className, String name) {
		return attributesByName.get(attributeKey(domain, className, name));
	}

	public Relationship getRelationship(String domain, BigInteger number) {
		return relationshipsByName.get(relationshipKey(domain, number));
	}

	public Association getAssociation(String domain, BigInteger number) {
		return (Association) getRelationship(domain, number);
	}

	public Generalization getGeneralization(String domain, BigInteger number) {
		return (Generalization) getRelationship(domain, number);
	}

}
