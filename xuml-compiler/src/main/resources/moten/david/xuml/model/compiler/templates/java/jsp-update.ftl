<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.google.inject.Injector"%>
<%@page import="${interfaceFullName}"%>
<html>
<% 
	Injector injector = (Injector) getServletContext().getAttribute("guiceInjector");
	EntityManagerFactory emf = injector.getInstance(EntityManagerFactory.class);
	EntityManager em = emf.createEntityManager();
	int id = Integer.parseInt(request.getParameter("id"));
	boolean update = "true".equals(request.getParameter("update"));
	em.getTransaction().begin();
	${name} bean = (${name}) em.createQuery("from ${name} where id=:id").setParameter("id",id).getSingleResult();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	if (update) {
<#list attributes as attribute>
<#if attribute.name!="id" && !attribute.derived>
	<#assign requestParameter>request.getParameter("${attribute.name}")</#assign>
	<#assign parse>(${requestParameter}==null||${requestParameter}.equals("")?null:${attribute.type?cap_first}.parse${attribute.type?cap_first}(${requestParameter}))</#assign>
	<#if attribute.type="String">
		<#assign parse>${requestParameter}</#assign>
	</#if>
	<#if attribute.type="Date">
		<#assign parse>sdf.parse(${requestParameter})</#assign>
	</#if>
			${attribute.type} ${attribute.name} = ${parse};
			bean.set${attribute.name?cap_first}(${attribute.name});
</#if>
</#list>
	}
	em.getTransaction().commit();
	em.close();
	%>
	<h3>${name} Update</h3>
	<form name="input" action="" method="get">
		<input name="update" value="true" type="hidden"/>
		<table border="1">
			<tr><td>Id</td><td><input name="id" value="<%= bean.getId()%>" type="text" readonly="false"/></td></tr>
<#list attributes as attribute>
<#if attribute.name!="id" && !attribute.derived>
	<#assign val><%=(bean.get${attribute.name?cap_first}()==null?"":bean.get${attribute.name?cap_first}())%></#assign>
	<#if attribute.type="Date">
		<#assign val><%=sdf.format(bean.get${attribute.name?cap_first}())%></#assign>
	</#if>
			<tr><td>${attribute.name?cap_first}</td><td><input name="${attribute.name}" type="text" value="${val}" size="100"/></td></tr>
</#if>
</#list>
		</table><br/>
		<input type="submit" value="Save"/>
	</form>
	<%
%>
</html>