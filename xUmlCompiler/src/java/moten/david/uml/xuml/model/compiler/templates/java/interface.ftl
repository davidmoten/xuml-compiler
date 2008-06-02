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

public interface ${name}  {
<#list attributes as attribute>
<#if !attribute.derived>

	/**
	 * ${(attribute.description)!"getter for ${attribute.name}"}
	 */
    public ${attribute.type} get${attribute.name?cap_first}();

	/**
	 * ${(attribute.description)!"setter for ${attribute.name}"}
	 */
	public void set${attribute.name?cap_first}(${attribute.type} ${attribute.name});
</#if>	
</#list>
<#list operations as operation>
<#assign opReturns><#if operation.returns?exists><#if operation.returnsMultiple>${"java.util.List\l"}${operation.returns}${"\g"}<#else>${operation.returns}</#if><#else>void</#if></#assign>
<#assign parametersDeclaration><#list operation.parameters as param><#if param_index!=0>, </#if>${param.type} ${param.name}</#list></#assign>
	
	/**
	* operation ${operation.name}
	**/
	public ${opReturns} ${operation.name}(${parametersDeclaration});
</#list>
<#list associations as association>
<#assign otherType><#if association.other.multiple>${"Set\l"}</#if>${association.other.class}<#if association.other.multiple>${"\g"}</#if></#assign>
<#assign otherName>${association.other.role?uncap_first}</#assign>
<#assign thisName>${association.this.role?uncap_first}</#assign>
<#assign otherColumn>${association.other.role}_id</#assign>
<#assign collectionType>Set</#assign>
<#if association.other.persistence?exists>
<#if association.other.persistence.orderBy?exists>
	<#assign collectionType>List</#assign>
</#if>
</#if>
<#if association.other.multiple>

	/**
	* via association "${association.name}"
	**/
	public ${collectionType}<${association.other.type}> get${otherName?cap_first}();

	/**
	* via association "${association.name}"
	**/
	public void set${otherName?cap_first}(${collectionType}<${association.other.type}> ${otherName});
<#else>

	/**
	* via association "${association.name}"
	**/
	public ${association.other.type} get${otherName?cap_first}();

	/**
	* via association "${association.name}"
	**/
	public void set${otherName?cap_first}(${association.other.type} ${otherName});
</#if>
</#list>
<#if events?exists>
<#list events as event>
	
	/**
	* process the received ${event.type?cap_first} event <em>${event.name}</em>
	*/
	public void processEvent(final Event${event.name?cap_first} event);
</#list>
<#list events as event>

	/** 
	* Event <em>${event.name}</em>
	* <#if event.description?exists>${event.description}</#if>
	*/
	public static class Event${event.name?cap_first} {
	<#if event.type="timer">
		
		/**
		* the wait time for a timer event
		*/
		private long timeMs;
		
		/**
		* check interval 
		**/
		private long checkIntervalMs = 50;
	</#if>
	<#list event.parameters as parameter>
	
		/**
		* * <#if parameter.description?exists>${parameter.description}</#if>
		*/
		private ${parameter.type} ${parameter.name};
	</#list>
	<#if event.type="timer">

		/**
		* the wait time for a timer event
		*/
		public long getTimeMs(){
			return timeMs;
		}
		
		public void setTimeMs(long timeMs) {
			this.timeMs = timeMs;
		}
		
		/**
		* the check interval for a timer event
		*/
		public long getCheckIntervalMs(){
			return checkIntervalMs;
		}
		
		public void setCheckIntervalMs(long checkIntervalMs) {
			this.checkIntervalMs = checkIntervalMs;
		}
	</#if>
	<#list event.parameters as parameter>
	
		/**
		* * <#if parameter.description?exists>${parameter.description}</#if>
		*/
		public ${parameter.type} get${parameter.name?cap_first}(){
			return ${parameter.name};
		}
		
		public void set${parameter.name?cap_first}(${parameter.type} ${parameter.name}){
			this.${parameter.name} = ${parameter.name};
		}
	</#list>
	}
</#list>
</#if>

<#if persistence?exists>
	/** 
	* static class to contain static search methods 
	*/
	public static class Search {
<#list attributes as attribute>
<#if !attribute.derived>
<#if attribute.unique>

		/**
		* find method based on uniqueness of the ${attribute.name} attribute
		*/
		@SuppressWarnings("unchecked")
		public static ${name} findBy${attribute.name?cap_first}(EntityManager em, ${attribute.type} ${attribute.name}) {
			List<${name}> list = (List<${name}>) em.createQuery(
					"from ${name}  where ${attribute.name}=:${attribute.name}")
					.setParameter("${attribute.name}", ${attribute.name})
					.getResultList();
			if (list.size()==0) 
				return null;
			else if (list.size()==1) 
				return list.get(0);
			else
				throw new Error("a unique column should not return more than one result here!"); 
		}
	</#if>
</#if>
</#list>
<#list identifiers as identifier>
		
		/**
		* find method based on uniqueness of identitifer ${identifier.name} <#list identifier.attributes as attribute> ${attribute.name} ${attribute.type}</#list>
		*/
		@SuppressWarnings("unchecked")
		public static ${name} findBy<#list identifier.attributes as attribute><#if attribute_index gt 0>_</#if>${attribute.name?cap_first}</#list>(EntityManager em,
			<#list identifier.attributes as attribute><#if attribute_index gt 0>, </#if>${attribute.type} ${attribute.name?uncap_first}</#list>){
				<#assign whereClause><#list identifier.attributes as attribute><#if attribute_index gt 0> and </#if>${attribute.name?uncap_first}<#if attribute.derived>.id</#if>=:${attribute.name}</#list></#assign>
				<#assign setParameters><#list identifier.attributes as attribute>.setParameter("${attribute.name?uncap_first}",${attribute.name?uncap_first}<#if attribute.derived>.get${attribute.idProperty?cap_first}()</#if>)</#list></#assign>
				List<${name}> list = (List<${name}>)  em.createQuery(
					"from ${name}  where ${whereClause}")
					${setParameters}
					.getResultList();
			if (list.size()==0) 
				return null;
			else if (list.size()==1) 
				return list.get(0);
			else
				throw new Error("a unique column should not return more than one result here!"); 
		}
</#list>
<#if persistence.indexes?exists>
	<#list persistence.indexes as index>
		
		/**
		* find method based on index ${index.name}
		*/
		@SuppressWarnings("unchecked")
		public static List<${name}> findBy<#list index.attributes as attribute><#if attribute_index gt 0>_</#if>${attribute.name?cap_first}</#list>(EntityManager em,
			<#list index.attributes as attribute><#if attribute_index gt 0>, </#if><#if attribute.derived>${attribute.name?cap_first}<#else>${attribute.type}</#if> ${attribute.name?uncap_first}</#list>){
				<#assign whereClause><#list index.attributes as attribute><#if attribute_index gt 0> and </#if>${attribute.name?uncap_first}<#if attribute.derived>.id</#if>=:${attribute.name}</#list></#assign>
				<#assign setParameters><#list index.attributes as attribute>.setParameter("${attribute.name?uncap_first}",${attribute.name?uncap_first}<#if attribute.derived>.get${attribute.idProperty?cap_first}()</#if>)</#list></#assign>
				List<${name}> list = (List<${name}>)  em.createQuery(
					"from ${name}  where ${whereClause}")
					${setParameters}
					.getResultList();
			return list;
		}
	</#list>
</#if>

		/**
		* returns all instances of ${name}
		*/
		@SuppressWarnings("unchecked")
		public static List<${name}> findAll(EntityManager em) {
			return (List<${name}>) em.createQuery("from ${name}").getResultList();
		}
		
		/**
		* returns all instances of ${name} satisfying the clause. Note that you might use a where clause and/or an order by clause.
		*/
		@SuppressWarnings("unchecked")
		public static List<${name}> findAll(EntityManager em, String clause) {
			return (List<${name}>) em.createQuery("from ${name} "+clause).getResultList();
		}
	}
</#if>
<#list attributes as attribute>
	<#if attribute.values?exists && attribute.values?size gt 0>
	
	/** 
	* static constants associated with the ${attribute.name} attribute
	*/
	public enum ${attribute.name?cap_first}Values {
<#list attribute.values as value>
		${value.valueIdentifier}("${value.value}")<#if value_index lt (attribute.values?size-1)>,</#if><#if value_index==attribute.values?size-1>;</#if>
</#list>
		
		private String value;
		
		private ${attribute.name?cap_first}Values(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	};
	</#if>
</#list>
}