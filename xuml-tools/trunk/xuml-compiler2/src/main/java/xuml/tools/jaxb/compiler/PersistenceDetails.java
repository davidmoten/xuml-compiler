package xuml.tools.jaxb.compiler;

import xuml.metamodel.jaxb.Attribute;
import xuml.metamodel.jaxb.Class;
import xuml.tools.jaxb.Util;

public class PersistenceDetails {

	public String getTableName(Class cls) {
		return Util.toTableName(cls.getName());
	}

	public String getSchemaName(Class cls) {
		return Util.toTableName(cls.getDomain());
	}

	public String getColumnName(Class cls, Attribute a) {
		return Util.toTableName(a.getName());
	}

}
