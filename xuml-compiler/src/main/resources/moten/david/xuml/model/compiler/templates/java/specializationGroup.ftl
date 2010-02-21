package ${package}<#if interfacePackageExtension?exists>.${interfacePackageExtension}</#if>;

<#list imports as import>
<#if (import.name)?contains(".")>import ${import.name};
</#if>
</#list>

import java.util.Set;
import java.util.List;
import javax.persistence.EntityManager;
<#if operationsPackageExtension?exists>import ${package}.${operationsPackageExtension}.*;</#if>

/**
* ${description!""}
*
* @generated
* @generatedBy xUML
*/

public interface ${name}${specializationGroup.name} {

	public ${specializationGroup.generalization.name} get${specializationGroup.generalization.name}();
	
	public void set${specializationGroup.generalization.name}(${specializationGroup.generalization.name} ${specializationGroup.generalization.name?uncap_first}); 

}