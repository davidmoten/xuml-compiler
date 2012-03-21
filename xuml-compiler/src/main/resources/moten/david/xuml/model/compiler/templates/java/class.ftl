<#assign underscore = "moten.david.util.freemarker.UnderscoreDirective"?new()>
package ${package}<#if classPackageExtension?exists>.${classPackageExtension}</#if>;

<#compress>
<#list imports as import>
<#if (import.name)?contains(".")>
import ${import.name};
</#if>
</#list>
<#if persistence?exists>
import javax.persistence.*;
</#if>
//import org.apache.log4j.Logger;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import com.google.inject.Inject;
import ${package}.*;
import ${package}.actions.*;
<#if interfacePackageExtension?exists>import ${package}.${interfacePackageExtension}.*;</#if>
<#if operationsPackageExtension?exists>import ${package}.${operationsPackageExtension}.*;</#if>
</#compress>

/**
* <#if description?exists>${description}</#if> 
*
* @generated
* @generatedBy xUML
*/
<#if persistence?exists>
<#assign persistenceTable><#if (persistence.table)?exists>${persistence.table}<#else><@underscore>${name}</@underscore></#if></#assign>
@Entity(name="${name}")
<#--
	<#if isGeneralization>
@Inheritance(strategy=InheritanceType.JOINED)<#rt/>
	</#if>
-->
@Table(name="${persistenceTable}"<#rt/>
		<#if (persistence.schema)?exists>, schema="${persistence.schema}"</#if><#lt/><#if identifiers?size gt 0>, 
	uniqueConstraints={<#list identifiers as identifier><#if identifier_index gt 0>,</#if>
		//identifier ${identifier.name}
		@UniqueConstraint(columnNames={<#list identifier.attributes as attribute><#if attribute_index gt 0>,</#if>"<@underscore>${attribute.name}</@underscore><#if attribute.derived>_id</#if>"</#list>})</#list>}</#if><#rt/>)
	</#if>
	<#if persistence.indexes?exists>
@org.hibernate.annotations.Table(
	appliesTo="${persistenceTable}",
	indexes = {<#list persistence.indexes as index>
		@org.hibernate.annotations.Index(
			name="${index.name}", 
			columnNames={<#list index.attributes as att><#if att_index gt 0>, </#if>"<@underscore>${att.name}</@underscore>"</#list>})</#list>})
</#if>
public class ${name}Impl implements ${name} {

	/**
	* static logger
	**/
	//private static Logger log = Logger.getLogger(${name}Impl.class);

	/**
	* constructor has default access to ensure that instantiation 
	* occurs via the factory.
	*/
	protected ${name}Impl(){
		//
	}
<#if states?exists>
	<#assign initialStateCapital><@underscore>${initialState}</@underscore></#assign>
	private enum State {${initialStateCapital?upper_case}<#list states as state>, <#assign tempName><@underscore>${state.name}</@underscore></#assign>${tempName?upper_case}</#list>};
	
	private State state = State.${initialStateCapital?upper_case};
</#if>
<#assign isCompositeId=false/>
<#if identifierPrimary?exists>
	<#if identifierPrimary.attributes?size gt 1>
		<#assign isCompositeId=true/>
	</#if>
</#if>
<#assign pkType>${name?cap_first}PrimaryKey</#assign>
<#if isCompositeId=true>

	private ${pkType} primaryKey;

	@Id
	public ${pkType} getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(${pkType} primaryKey){
		this.primaryKey = primaryKey;
	}
</#if>
<#list attributes as attribute>
<#if !attribute.derived>

	/**
	* ${(attribute.description)!"member field for ${attribute.name}"}
	*/
	private ${attribute.type} ${attribute.name} ;
</#if>
</#list>
<#list associations as association>
<#assign collectionType>Set</#assign>
<#assign collectionTypeImpl>HashSet</#assign>
<#if association.other.persistence?exists>
<#if association.other.persistence.orderBy?exists>
	<#assign collectionType>List</#assign>
	<#assign collectionTypeImpl>ArrayList</#assign>
</#if>
</#if>
<#assign otherType><#if association.other.multiple>${"Set\l"}</#if>${association.other.class}<#if association.other.multiple>${"\g"}</#if></#assign>
<#assign otherName>${association.other.role?uncap_first}</#assign>
<#assign thisName>${association.this.role?uncap_first}</#assign>
<#assign otherColumn><@underscore>${association.other.role}</@underscore>_id</#assign>

	/**
	* role for association "${association.name}" (inverse role is ${thisName})
	*/
<#if association.other.multiple>
	private ${collectionType}<${association.other.type}> ${otherName} = new ${collectionTypeImpl}<${association.other.type}>();
<#else>
	private ${association.other.type} ${otherName};
</#if>
</#list>
<#if (operations?size gt 0) || (events?exists && (events?size gt 0))>

	/**
	*	implementation of the operations interface for this class
	*
	*/
	private ${name}Actions ${name?uncap_first}Actions;

	/**
	* getter for the implementation of the operations interface for this class
	*
	*/
	@Transient
	public ${name}Actions get${name?cap_first}Actions() {
		return ${name?uncap_first}Actions;
	}

	/**
	* setter for the implementation of the operations interface for this class.
	* This field is set via <b>guice</b> injection.
	*
	*/
	@Inject
	public void set${name?cap_first}Actions(${name}Actions ${name?uncap_first}Actions) {
		this.${name?uncap_first}Actions=${name?uncap_first}Actions;
		this.${name?uncap_first}Actions.set${name?cap_first}(this);
	}

	/**
	* on load of this object from persistence necessary operations are injected.
	* This ensures that the object operations are available before the object is "used in anger".
	*/
//Versions 3.5 and 3.6 of Hibernate have a bug to do with PostLoad so workaround with checkActions()
//See http://opensource.atlassian.com/projects/hibernate/browse/HHH-6043
//	@PostLoad
	public void inject() {
		ObjectFactory.instance.injectMembers(this);
	}
	
	/** 
	* check that operations have been injected
	*/
	private synchronized void checkActions(){
		if (${name?uncap_first}Actions==null)
			inject();
		if (${name?uncap_first}Actions==null)
			throw new Error(
				"no implementation for operations has been injected yet! Perhaps there is no binding for ${name}Actions.class in the InjectorModule.");
	}
</#if>
<#list attributes as attribute>
<#if !attribute.derived>

	<#assign attributeName><@underscore><#if attribute.name?upper_case="ID">${name}Id<#else>${attribute.name}</#if></@underscore></#assign>
	/**
	 * ${(attribute.description)!"getter for ${attribute.name}"}
	 */
	 <#assign otherParams>nullable=<#if attribute.nullable>true<#else>false</#if>, unique=<#if attribute.unique>true<#else>false</#if></#assign>
    <#if persistence?exists>
    	<#if attribute.persistence?exists>
    		<#if attribute.persistence.id>
	@Id
    		</#if>
    		<#if attribute.persistence.column??>
    @Column(name="${attribute.persistence.column}", ${otherParams})
       		<#else>
	@Column(name="<@underscore>${attributeName}</@underscore>", ${otherParams})
       		</#if>
       		<#if attribute.persistence.generatedBySequence>
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name="generator", sequenceName="SEQ_${name?upper_case}_id", allocationSize=1)
       		<#elseif attribute.persistence.generatedValue>
	@GeneratedValue
			<#elseif attribute.persistence.generatedByIdentity>
			</#if>
		<#else>
	@Column(name="<@underscore>${attributeName}</@underscore>", ${otherParams})
    	</#if>
		<#if attribute.primitive="Date" && attribute.utc>
    @org.hibernate.annotations.Type(type="moten.david.util.hibernate.utc.DateType")
    	<#elseif attribute.primitive="Date" && !attribute.utc>
    @Temporal(TemporalType.DATE)
    	<#elseif attribute.primitive="Time" && attribute.utc>
    @org.hibernate.annotations.Type(type="moten.david.util.hibernate.utc.TimeType")
    	<#elseif attribute.primitive="Time" && !attribute.utc>
    @Temporal(TemporalType.TIME)
    	<#elseif attribute.primitive="Timestamp" && attribute.utc>
    @org.hibernate.annotations.Type(type="moten.david.util.hibernate.utc.TimestampType")
    	<#elseif attribute.primitive="Timestamp" && !attribute.utc>
    @Temporal(TemporalType.TIMESTAMP)
    	<#elseif attribute.primitive="Boolean" && attribute.yesNo>
    @org.hibernate.annotations.Type(type="yes_no")
    	</#if>
    </#if>
	public ${attribute.type} get${attribute.name?cap_first}(){
		return ${attribute.name};
	}

	/**

	 * ${(attribute.description)!"setter for ${attribute.name}"}
	 */
	public void set${attribute.name?cap_first}(${attribute.type} ${attribute.name}){
		this.${attribute.name} = ${attribute.name};
	}
</#if>
</#list>
<#list operations as operation>
<#assign opReturns><#if operation.returns?exists><#if operation.returnsMultiple>${"java.util.List\l"}${operation.returns}${"\g"}<#else>${operation.returns}</#if><#else>void</#if></#assign>
<#assign parametersDeclaration><#list operation.parameters as param><#if param_index!=0>, </#if>${param.type}<#if param.multiple>[]</#if> ${param.name}</#list></#assign>
<#assign parametersList><#list operation.parameters as param><#if param_index!=0>, </#if>${param.name}</#list></#assign>

	@Transient
	public ${opReturns} ${operation.name}(${parametersDeclaration}){
		checkActions();
		${name?uncap_first}Actions.set${name}(this);
		<#if opReturns!="void">return </#if>${name?uncap_first}Actions.${operation.name}(${parametersList});
	}
</#list>
<#list associations as association>
<#if association.associationClass?exists>
	<#if association.associationClassTable?exists>
		<#assign joinTable>${association.associationClassTable}</#assign>
	<#else>
		<#assign joinTable><@underscore>${association.associationClass}</@underscore></#assign>
	</#if>
<#else>
	<#assign joinTable><@underscore>${association.this.role?uncap_first}${association.other.role?cap_first}</@underscore></#assign>
</#if>
<#assign otherType><#if association.other.multiple>${"Set\l"}</#if>${association.other.class}<#if association.other.multiple>${"\g"}</#if></#assign>
<#assign otherName>${association.other.role?uncap_first}</#assign>
<#assign thisName>${association.this.role?uncap_first}</#assign>
<#assign otherColumn><@underscore>${association.other.role}</@underscore>_id</#assign>

<#-- 1 to 0..1 -->
<#if !association.this.multiple
  && association.this.mandatory
  && !association.other.multiple
  && !association.other.mandatory>
	/**
	* 1 to 0..1 (association "${association.name}")
	*/
	@OneToOne(
		mappedBy = "${thisName}",
		fetch=FetchType.LAZY,
		targetEntity=${association.other.classImpl}.class)
<#-- 0..1 to 1 -->
<#elseif !association.this.multiple
  && !association.this.mandatory
  && !association.other.multiple
  && association.other.mandatory>
    /**
    * 0..1 to 1 (association "${association.name}")
    */
	@OneToOne(targetEntity=${association.other.classImpl}.class<#if generalizations?exists>,cascade=CascadeType.ALL</#if>, fetch=FetchType.LAZY)
	@JoinColumn(name = "${otherColumn}",nullable = false)
<#-- 1 to 1 primary -->
<#elseif !association.this.multiple
  && association.this.mandatory
  && !association.other.multiple
  && association.other.mandatory
  && association.this.primary>
	@Transient
	public boolean valid${otherName?cap_first}() {
		return get${otherName?cap_first}()!=null;
	}

	public void checkValid${otherName?cap_first}() {
		if (!valid${otherName?cap_first}())
			throw new RuntimeException(
				"cannot update, record not valid due to a relationship not being established");
	}
<#assign prePersist>${prePersist!""}
		checkValid${otherName?cap_first}();
</#assign>

	/**
	* 1 .. 1 primary (association "${association.name}")
	*/
	@OneToOne(
		mappedBy = "${thisName}",
		fetch=FetchType.LAZY,
		targetEntity=${association.other.classImpl}.class)
<#-- 1 to 1 secondary -->
<#elseif !association.this.multiple
  && association.this.mandatory
  && !association.other.multiple
  && association.other.mandatory
  && !association.this.primary>
  	/**
  	* 1 .. 1 secondary (association "${association.name}")
  	*/
	@OneToOne(targetEntity=${association.other.classImpl}.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "${otherColumn}",nullable = false)
<#-- 1 to * -->
<#elseif !association.this.multiple
  && association.this.mandatory
  && association.other.multiple
  && !association.other.mandatory>
  	/**
  	* 1 .. * (association "${association.name}")
  	*/
	@OneToMany(
		mappedBy = "${thisName}",
		cascade=CascadeType.ALL,
		fetch=FetchType.LAZY,
		targetEntity=${association.other.classImpl}.class)
<#-- * to 1 -->
<#elseif association.this.multiple
  && !association.this.mandatory
  && !association.other.multiple
  && association.other.mandatory>
  	/**
  	* * to 1 (association "${association.name}")
  	*/
	@ManyToOne(
	    targetEntity=${association.other.classImpl}.class,
	    fetch=FetchType.LAZY
	)
	@JoinColumn(name = "${otherColumn}",nullable = false)
<#-- 1 to 1..* -->
<#elseif !association.this.multiple
  && association.this.mandatory
  && association.other.multiple
  && association.other.mandatory>
	public boolean valid${otherName?cap_first}() {
		return get${otherName?cap_first}()!=null && get${otherName?cap_first}().size()>=1;
	}

	public void checkValid${otherName?cap_first}() {
		if (!valid${otherName?cap_first}())
			throw new RuntimeException(
				"cannot persist/update, record not valid");
	}
<#assign prePersist>${prePersist!""}
		checkValid${otherName?cap_first}();
</#assign>

	/**
	* 1 to 1..* (association "${association.name}")
	*/
	@OneToMany(
		mappedBy = "${thisName}",
		cascade=CascadeType.ALL,
		fetch=FetchType.LAZY,
		targetEntity=${association.other.classImpl}.class)
<#-- 1..* to 1 -->
<#elseif association.this.multiple
  && association.this.mandatory
  && !association.other.multiple
  && association.other.mandatory>
	/**
	* 1..* to 1 (association "${association.name}")
	*/
	@ManyToOne(targetEntity=${association.other.classImpl}.class)
	@JoinColumn(name = "${otherColumn}",nullable = false)
<#-- 0..1 to 0..1 primary -->
<#elseif !association.this.multiple
  && !association.this.mandatory
  && !association.other.multiple
  && !association.other.mandatory
  && association.this.primary>
	/**
	* 0..1 to 0..1 primary (association "${association.name}")
	*/
	@OneToOne(
		mappedBy = "${thisName}",
		fetch=FetchType.LAZY,
		targetEntity=${association.other.classImpl}.class)
<#-- 0..1 to 0..1 secondary -->
<#elseif !association.this.multiple
  && !association.this.mandatory
  && !association.other.multiple
  && !association.other.mandatory
  && !association.this.primary>
	/**
	* 0..1 to 0..1 secondary (association "${association.name}")
	*/
	@OneToOne(targetEntity=${association.other.classImpl}.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "${otherColumn}",nullable = true)
<#-- 0..1 to * -->
<#elseif !association.this.multiple
  && !association.this.mandatory
  && association.other.multiple
  && !association.other.mandatory>
	/**
	* 0..1 to * (association "${association.name}")
	*/
  	@OneToMany(
  		mappedBy = "${thisName}",
  		cascade=CascadeType.ALL,
  		fetch=FetchType.LAZY,
  		targetEntity=${association.other.classImpl}.class)
<#-- * to 0..1 -->
<#elseif association.this.multiple
  && !association.this.mandatory
  && !association.other.multiple
  && !association.other.mandatory>
	/**
	* * to 0..1 (association "${association.name}")
	*/
	@ManyToOne(targetEntity=${association.other.classImpl}.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "${otherColumn}", nullable = true)
<#-- 0..1 to 1..* -->
<#elseif !association.this.multiple
  && !association.this.mandatory
  && association.other.multiple
  && association.other.mandatory>
	public boolean valid${otherName?cap_first}() {
		return get${otherName?cap_first}()!=null && get${otherName?cap_first}().size()>=1;
	}

	public void checkValid${otherName?cap_first}() {
		if (!valid${otherName?cap_first}())
			throw new RuntimeException(
				"cannot persist/update, record not valid");
	}
<#assign prePersist>${prePersist!""}
		checkValid${otherName?cap_first}();
</#assign>

	/**
	* 0..1 to 1..* (association "${association.name}")
	*/
  	@OneToMany(
  		mappedBy = "${thisName}",
  		cascade=CascadeType.ALL,
  		fetch=FetchType.LAZY,
  		targetEntity=${association.other.classImpl}.class)
<#-- 1..* to 0..1 -->
<#elseif association.this.multiple
  && association.this.mandatory
  && !association.other.multiple
  && !association.other.mandatory>
	/**
	* 1..* to 0..1 (association "${association.name}")
	*/
	@ManyToOne(targetEntity=${association.other.classImpl}.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "${otherColumn}",nullable = true)
<#-- * to * primary-->
<#elseif association.this.multiple
  && !association.this.mandatory
  && association.other.multiple
  && !association.other.mandatory
  && association.this.primary>
	/**
	* * to * primary (association "${association.name}")
	*/
	@ManyToMany(
					targetEntity = ${association.other.classImpl}.class,
					cascade=CascadeType.ALL,
					fetch=FetchType.LAZY)
	@JoinTable(
    	name="${joinTable}",
    	<#if (persistence.schema)?exists>
    	schema="${persistence.schema}",
    	</#if>
    	joinColumns=
      		@JoinColumn(name="<@underscore>${association.this.role}</@underscore>_id"),
    			inverseJoinColumns=
      			@JoinColumn(name="<@underscore>${association.other.role}</@underscore>_id"))
<#-- * to * secondary -->
<#elseif association.this.multiple
  && !association.this.mandatory
  && association.other.multiple
  && !association.other.mandatory
  && !association.this.primary>
	/**
	* * to * secondary (association "${association.name}")
	*/
	@ManyToMany(
				mappedBy="${thisName}",
    			targetEntity=${association.other.classImpl}.class,
    			cascade=CascadeType.ALL,
    			fetch=FetchType.LAZY)
<#-- 1..* to 1..* primary -->
<#elseif association.this.multiple
  && association.this.mandatory
  && association.other.multiple
  && association.other.mandatory
  && association.this.primary>
	public boolean valid${otherName?cap_first}() {
		return get${otherName?cap_first}()!=null && get${otherName?cap_first}().size()>=1;
	}

	public void checkValid${otherName?cap_first}() {
		if (!valid${otherName?cap_first}())
			throw new RuntimeException(
				"cannot persist/update, record not valid");
	}
<#assign prePersist>${prePersist!""}
		checkValid${otherName?cap_first}();
</#assign>

	/**
	* 1..* to 1..* primary (association "${association.name}")
	*/
	@ManyToMany(
				targetEntity = ${association.other.classImpl}.class,
				cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	@JoinTable(
    	name="${joinTable}",
    	<#if (persistence.schema)?exists>
    	schema="${persistence.schema}",
    	</#if>
    	joinColumns=
      		@JoinColumn(name="<@underscore>${association.this.role}</@underscore>_id",nullable=false),
    			inverseJoinColumns=
      			@JoinColumn(name="<@underscore>${association.other.role}</@underscore>_id"))
<#-- 1..* to 1..* secondary -->
<#elseif association.this.multiple
  && association.this.mandatory
  && association.other.multiple
  && association.other.mandatory
  && !association.this.primary>
	/**
	* 1..* to 1..* secondary (association "${association.name}")
	*/
	@ManyToMany(
				mappedBy="${thisName}",
    			targetEntity=${association.other.classImpl}.class,
    			cascade=CascadeType.ALL,
    			fetch=FetchType.LAZY)
<#-- 1..* to * -->
<#elseif association.this.multiple
  && association.this.mandatory
  && association.other.multiple
  && !association.other.mandatory>
	/**
	* 1..* to * (association "${association.name}")
	*/
	@ManyToMany(
				mappedBy="${thisName}",
    			targetEntity=${association.other.classImpl}.class,
    			cascade=CascadeType.ALL,
    			fetch=FetchType.LAZY)
<#-- * to 1..*  -->
<#elseif association.this.multiple
  && !association.this.mandatory
  && association.other.multiple
  && association.other.mandatory>
	public boolean valid${otherName?cap_first}() {
		return get${otherName?cap_first}()!=null && get${otherName?cap_first}().size()>=1;
	}

	public void checkValid${otherName?cap_first}() {
		if (!valid${otherName?cap_first}())
			throw new RuntimeException(
				"cannot persist/update, record not valid");
	}
<#assign prePersist>${prePersist!""}
		checkValid${otherName?cap_first}();
</#assign>

	/**
	* * to 1..* primary (association "${association.name}")
	*/
	@ManyToMany(
				targetEntity = ${association.other.classImpl}.class,
				cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	@JoinTable(
    	name="${joinTable}",
    	<#if (persistence.schema)?exists>
    	schema="${persistence.schema}",
    	</#if>
    	joinColumns=
      		@JoinColumn(name="<@underscore>${association.this.role}</@underscore>_id"),
    			inverseJoinColumns=
      			@JoinColumn(name="<@underscore>${association.other.role}</@underscore>_id"))
<#else>
  This is a problem, one of the if clauses is not working!
</#if>
<#assign collectionType>Set</#assign>
<#if association.other.persistence?exists>
<#if association.other.persistence.orderBy?exists>
	<#assign collectionType>List</#assign>
	@OrderBy("<#list association.other.persistence.orderBy as orderBy><#rt/>
<#if orderBy_index gt 0>,</#if>`${orderBy.name}`<#rt/>
</#list>")
</#if>
</#if>
<#if association.other.multiple>
	public ${collectionType}<${association.other.type}> get${otherName?cap_first}(){
		return ${otherName};
	}

	public void set${otherName?cap_first}(${collectionType}<${association.other.type}> ${otherName}){
		this.${otherName}=${otherName};
	}
<#else>
	public ${association.other.type} get${otherName?cap_first}(){
		return ${otherName};
	}

	public void set${otherName?cap_first}(${association.other.type} ${otherName}){
		this.${otherName}=${otherName};
	}
</#if>
</#list>
<#if states?exists>
 
 	@Column(name="state")
	public String getStateValue() {
		return getState().toString();
	}
	
	public void setStateValue(String stateString) {
		setState(State.valueOf(stateString));
	}
	
	@Transient
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
</#if>
<#if events?exists>
<#list events as event>
	
	/**
	* Processes the received ${event.type?cap_first} event <em>${event.name}</em>. Synchronizes on <code>this<code>.
	*/
	public void processEvent(final ${name}.Event${event.name?cap_first} event) {
		processEvent(event,true);
	}

	/**
	* Processes the received ${event.type?cap_first} event <em>${event.name}</em>. If signalling self from an onEntry event then use lock=false in that signal.
	*/
	public void processEvent(final ${name}.Event${event.name?cap_first} event,boolean lock) {
		//log.debug("processing event ${event.name}");
<#list event.transitions as transition>
		<#if transition_index gt 0>else</#if>
		if (state.equals(State.<#assign tempName><@underscore>${transition.fromState}</@underscore></#assign>${tempName?upper_case})){
			<#if event.type="signal">
			state = State.<#assign tempName><@underscore>${transition.toState}</@underscore></#assign>${tempName?upper_case};
			final Object thisObject = this;
			Thread t = new Thread(new Runnable() {
					public void run() {
						checkActions();
						synchronized (thisObject) {
							//log.debug("performOnEntry${transition.toState?cap_first}");
							${name?uncap_first}Actions.performOnEntry${transition.toState?cap_first}(event);
						}
					}
				});
			t.start();
			<#elseif event.type="call">
			state = State.<#assign tempName><@underscore>${transition.toState}</@underscore></#assign>${tempName?upper_case};
			checkActions();
			if (lock)
				synchronized (this) {
					//log.debug("performOnEntry${transition.toState?cap_first}");
					${name?uncap_first}Actions.performOnEntry${transition.toState?cap_first}(event);
				}
			else 
					${name?uncap_first}Actions.performOnEntry${transition.toState?cap_first}(event);
			<#elseif event.type="timer">
			final Object thisObject = this;
			if (event.getTimeMs()<=0) {
				state = State.<#assign tempName><@underscore>${transition.toState}</@underscore></#assign>${tempName?upper_case};
				checkActions();
				synchronized (thisObject) {
					//log.debug("performOnEntry${transition.toState?cap_first}");
					${name?uncap_first}Actions.performOnEntry${transition.toState?cap_first}(event);
				}
			} else {
				Thread t = new Thread(new Runnable() {
						public void run() {
							while (event.getTimeMs()>0) {
								try {
									long interval = event.getCheckIntervalMs();
									Thread.sleep(interval);
									event.setTimeMs(Math.max(event.getTimeMs()-interval,0));
									//log.info("timer value = " + event.getTimeMs());
								} catch (InterruptedException e) {
									//ignore
								}
							}
							processEvent(event);
						}
					});
				t.start();
			}
			<#else>
			unknown event type ${event.type}!
			</#if>
		}
</#list>
	}
</#list>
</#if>

<#list specializationGroups as specializationGroup>
	private void checkValidSpecializationGroup${specializationGroup.name?cap_first}(){
		int count=0;
		List<String> list = new ArrayList<String>();
		<#list specializationGroup.specializations as specialization>
		if (get${specialization.class?cap_first}()!=null){
			count++;
			list.add("${specialization.class}");
		}
		</#list>
		if (count==0)
			throw new RuntimeException("class is abstract, one specialization must be set");
		else if (count>1) 
			throw new RuntimeException("only one specialization can be set. Currently set are " + list);
	}
	
</#list>
<#assign prePersist>
${prePersist!""}
<#list specializationGroups as specializationGroup>
		checkValidSpecializationGroup${specializationGroup.name?cap_first}();
</#list>
</#assign>

<#if prePersist?exists>

	@PreUpdate
	@Transient
	public void checkValid() {
${prePersist}
	}
</#if>

}

<#if isCompositeId>
@Embeddable
class ${pkType} {

}
</#if> 
