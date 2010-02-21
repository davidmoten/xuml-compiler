package ${package};

import ${package}.impl.*;

public interface ObjectFactory {

	/**
	 * The singleton instance of the factory.
	 *
	 */
	public ObjectFactory instance = ObjectFactoryImpl.getInstance();
<#list classes as class>
	<#if !class.isGeneralization>
	/**
	 * Returns a new object of class '<em>${class.name}</em>'.
	 */
	public ${class.name} create${class.name}();
	</#if>
</#list>

	/** 
	* injects members using guice
	*/
	public void injectMembers(Object object);

}