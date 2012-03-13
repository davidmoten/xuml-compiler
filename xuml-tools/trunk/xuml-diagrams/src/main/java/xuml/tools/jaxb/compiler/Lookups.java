package xuml.tools.jaxb.compiler;

import java.math.BigInteger;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.metamodel.jaxb.Generalization;
import xuml.metamodel.jaxb.Relationship;
import xuml.metamodel.jaxb.RelationshipEnd;
import xuml.metamodel.jaxb.System;

import com.google.common.collect.Maps;

class Lookups {
	private final Map<String, Class> classesByName = Maps.newHashMap();
	private final Map<String, Relationship> relationshipsByName = Maps
			.newHashMap();
	private final Map<String, Generalization> generalizationsByName = Maps
			.newHashMap();
	private final Map<String, Attribute> attributesByName = Maps.newHashMap();

	public Lookups(System system) {
		for (Class c : system.getClazz()) {
			classesByName.put(key(c), c);
			for (JAXBElement<? extends Attribute> a : c.getAttributeBase()) {
				attributesByName.put(
						attributeKey(c.getDomain(), c.getName(), a.getValue()
								.getName()), a.getValue());
			}
		}

		for (Relationship r : system.getRelationship())
			relationshipsByName.put(key(r), r);
		for (Generalization g : system.getGeneralization())
			generalizationsByName.put(key(g), g);
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

	private static String key(Generalization g) {
		return g.getNumber() + "";
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

	public Class getClass(RelationshipEnd e) {
		return getClass(e.getDomain(), e.getName());
	}

}