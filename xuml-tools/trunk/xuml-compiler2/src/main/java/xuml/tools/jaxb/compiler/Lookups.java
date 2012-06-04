package xuml.tools.jaxb.compiler;

import java.math.BigInteger;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import miuml.jaxb.Attribute;
import miuml.jaxb.Class;
import miuml.jaxb.ModeledDomain;
import miuml.jaxb.Relationship;
import miuml.jaxb.Subsystem;
import miuml.jaxb.SubsystemElement;

import com.google.common.collect.Maps;

class Lookups {
	private final Map<String, Class> classesByName = Maps.newHashMap();
	private final Map<BigInteger, Relationship> relationshipsByNumber = Maps
			.newHashMap();

	private final Map<String, Attribute> attributesByName = Maps.newHashMap();

	public Lookups(ModeledDomain domain) {
		for (Subsystem subsystem : domain.getSubsystem()) {
			for (JAXBElement<? extends SubsystemElement> ssElement : subsystem
					.getSubsystemElement()) {
				SubsystemElement val = ssElement.getValue();
				if (val instanceof Relationship) {
					relationshipsByNumber.put(((Relationship) val).getRnum(),
							(Relationship) val);
				} else if (val instanceof Class) {
					classesByName.put(((Class) val).getName(), (Class) val);
				}
			}
		}
	}

	public Relationship getRelationship(BigInteger number) {
		return relationshipsByNumber.get(number);
	}

	public Class getClassByName(String name) {
		return classesByName.get(name);
	}
}
