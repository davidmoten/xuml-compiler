package ${package}<#if actionsPackageExtension?exists>.${actionsPackageExtension}</#if>;

<#list imports as import>
<#if (import.name)?contains(".")>import ${import.name};
</#if>
</#list>
import java.util.Set;
import ${package}.*;
<#if interfacePackageExtension?exists>import ${package}.${interfacePackageExtension}.*;</#if>

/**
* Interface for actions specific to the class ${name}.
* This includes class operations as well as entry procedures 
* for states in the class state machine.
* ${description!""}
*
* @generated
* @generatedBy xUML
*/

public interface ${name}Actions {
<#list operations as operation>
<#assign opReturns><#if operation.returns?exists><#if operation.returnsMultiple>${"java.util.List\l"}${operation.returns}${"\g"}<#else>${operation.returns}</#if><#else>void</#if></#assign>
<#assign parametersDeclaration><#list operation.parameters as param><#if param_index!=0>, </#if>${param.type} ${param.name}</#list></#assign>

	/**
	* ${(operation.description)!""}
	*/
	public ${opReturns} ${operation.name}(${parametersDeclaration});
</#list>

	/**
	* setter for injection of relevant object
	*/
	public void set${name}(${name} ${name?uncap_first});
<#if events?exists>
<#list events as event>
	<#list event.toStates as toState>
	
	/**
	* this is the entry procedure for the state <em>${toState.name}</em>
	*/	
	public void performOnEntry${toState.name?cap_first}(${name}.Event${event.name?cap_first} event);
	</#list>
	
</#list>
</#if>
}