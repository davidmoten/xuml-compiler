<html>
<head>
<!--<link rel="stylesheet" type="text/css" href="file://C:\style.css" />-->
</head>
<body>
<h2>${name}</h2>
<div style="margin-right:30%">${description!}</div>
<#list packages as package>
<h3>${package.name}</h3>
	<#list package.classes as class>
<p style="font-weight:bold;font-size:large">${class.name}</p>
<#if class.description?exists>${class.description!}</#if>
<p style="font-weight:bold; font-style:italic">Attributes</p>
		<#list class.attributes as attribute>
<p style="margin-left:40px">${attribute.name}: ${attribute.type}</p>
			<#if attribute.description?exists>
				<p style="margin-left:40px">${attribute.description}</p></#if>
		</#list>
		<p style="font-weight:bold; font-style:italic">Associations &amp; Relationships</p>
		<#if class.assEnds?exists>
			<#list class.assEnds as ae>
				<p style="margin-left:40px;font-weight: bold">${ae.associationName}</p>
				<p style="margin-left:40px">${ae.otherVerbClause?upper_case} <#if ae.otherMandatory>1<#else>0</#if>..<#if ae.otherMultiple>*<#else>1</#if> ${ae.other}</p>
			<#if ae.associationDescription?exists>
				<p style="margin-left:60px">${ae.associationDescription}</p></#if>
			</#list>
		</#if>
	</#list>
</#list>
</body>
</html>