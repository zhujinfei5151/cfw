<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/Ext/head.jsp" />
<script type="text/javascript" src="Ext/org/cfw/login/control/Logins.js"></script>
<script type="text/javascript" src="Ext/org/cfw/login/view/Checkcode.js"></script>
<script type="text/javascript" src="Ext/org/cfw/login/view/Login.js"></script>
<style type="text/css">
.CheckCode {
	float: left;
}

.redfont {
	color: #ff0000;
	padding-left: 10px;
}

.x-form-code {
	width: 73px;
	height: 40px;
	vertical-align: middle;
	cursor: pointer;
	float: left;
	margin-left: 10px;
}
</style>
<title>通用信息系统框架 欢迎登录</title>
<script type="text/javascript">
	Ext.Loader.setConfig({
		enabled : true
	});

	var currentTheme = '<s:property value="#attr.currentTheme" />';
</script>
</head>
<body>
</body>
</html>