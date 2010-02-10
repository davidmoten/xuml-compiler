<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
    http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd"
	version="1.0">
	<persistence-unit name="${name}-derby" >
		<#list classes as class>
		<class>${class.name}</class>
		</#list>
		<exclude-unlisted-classes>true</exclude-unlisted-classes>
		<properties>
			<property name="hibernate.dialect" value="org.hibernate.dialect.DerbyDialect" />
			<property name="hibernate.hbm2ddl.auto" value="create" />
			<property name="hibernate.connection.driver_class" value="org.apache.derby.jdbc.EmbeddedDriver" />
			<property name="hibernate.connection.url" value="jdbc:derby:temp/db-${name};create=true" />
			<property name="hibernate.connection.pool_size" value= "5"/>
			<property name="hibernate.show_sql" value="true"/>
			<property name="hibernate.format_sql" value="true"/>
		</properties>
	</persistence-unit>
	<persistence-unit name="${name}-hsql" >
		<#list classes as class>
		<class>${class.name}</class>
		</#list>
		<exclude-unlisted-classes>true</exclude-unlisted-classes>
		<properties>
			<property name="hibernate.dialect" value="org.hibernate.dialect.HSQLDialect" />
			<property name="hibernate.hbm2ddl.auto" value="create-drop" />
			<property name="hibernate.connection.driver_class" value="org.hsqldb.jdbcDriver" />
			<property name="hibernate.connection.url" value="jdbc:hsqldb:mem:${name}" />
			<property name="hibernate.connection.pool_size" value= "1"/>
			<!-- <property name="hibernate.show_sql" value="true"/>  -->
			<property name="hibernate.format_sql" value="true"/>
		</properties>
	</persistence-unit>
</persistence>