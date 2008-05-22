package ${package}.${implementationPackageExtension};

import ${package}.*;
import ${package}.impl.*;

public class ObjectFactoryImpl implements ObjectFactory {

	/**
	 * The singleton instance of the factory.
	 *
	 */
	private static ObjectFactory factory = null;

	public synchronized static ObjectFactory getInstance() {
		if (factory==null)
			factory = new ObjectFactoryImpl();
		return factory;
	}
<#list classes as class>

	/**
	 * Returns a new object of class '<em>${class.name}</em>'.
	 */
	public ${class.name} create${class.name}() {
		${class.name} ${class.name?uncap_first} =  new ${class.name}Impl();
		injectMembers(${class.name?uncap_first});
		return ${class.name?uncap_first};
	}
</#list>

	public void injectMembers(Object object) {
		ObjectInjector.injectMembers(object);
	}
}