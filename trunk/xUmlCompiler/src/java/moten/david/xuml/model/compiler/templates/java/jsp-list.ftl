<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.inject.Injector"%>
<%@page import="${interfaceFullName}"%>
<html>
<% 
	Injector injector = (Injector) getServletContext().getAttribute("guiceInjector");
	EntityManagerFactory emf = injector.getInstance(EntityManagerFactory.class);
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	List<${name}> beans = (List<${name}>) em.createQuery("from ${name}").getResultList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	%>
	<h3>${name}</h3>
	<table border="1">
		<tr><th>Id</th>
<#list attributes as attribute>
	<#if attribute.name!="id" && !attribute.derived>
		<th>${attribute.name?cap_first}</th>	
	</#if>
</#list>
		</tr>
<%	for (${name} bean:beans) { %>
		<tr><td><%= bean.getId() %></td>
<#list attributes as attribute>
<#if attribute.name!="id" && !attribute.derived>
	<#assign val><%=(bean.get${attribute.name?cap_first}()==null?"":bean.get${attribute.name?cap_first}())%></#assign>
	<#if attribute.type="Date">
		<#assign val><%=sdf.format(bean.get${attribute.name?cap_first}())%></#assign>
	</#if>
			<td>${val}</td>
</#if>
</#list>
			<td><a href="update${name}.jsp?id=<%=bean.getId()%>">Edit</a></td>
		</tr>
<% } %>
	</table><br/>
	<%
	em.getTransaction().commit();
	em.close();
%>
</html>