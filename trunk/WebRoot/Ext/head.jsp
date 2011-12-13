<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<s:if test="#attr.currentTheme != null">
	<link rel="stylesheet" type="text/css" href="frame/ExtJs/resources/css/<s:property value="#attr.currentTheme" />.css">
</s:if>
<s:else>
	<link rel="stylesheet" type="text/css" href="frame/ExtJs/resources/css/ext-all.css">
</s:else>
<link rel="stylesheet" type="text/css" href="resources/css/left-tree.css">
<link rel="stylesheet" type="text/css" href="resources/css/menu.css">
<script type="text/javascript" src="frame/ExtJs/ext-all-debug.js"></script>
<script type="text/javascript" src="Ext/org/cfw/common/common.js"></script>