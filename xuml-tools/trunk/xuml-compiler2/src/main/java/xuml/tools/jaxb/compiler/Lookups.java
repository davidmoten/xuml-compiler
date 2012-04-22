package xuml.tools.jaxb.compiler;

import java.util.Map;

import miuml.jaxb.Attribute;
import miuml.jaxb.Class;
import miuml.jaxb.Domains;
import miuml.jaxb.Relationship;

import com.google.common.collect.Maps;

class Lookups {
	private final Map<String, Class> classesByName = Maps.newHashMap();
	private final Map<String, Relationship> relationshipsByName = Maps
			.newHashMap();

	private final Map<String, Attribute> attributesByName = Maps.newHashMap();
	private final Domains domains;

	public Lookups(Domains domains) {
		this.domains = domains;

	}

}
