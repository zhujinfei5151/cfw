<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="Ext/org/cfw/common/common.js"></script>
<script type="text/javascript">
function hideMainMenu() {
	var menuMgr = null;
	try {
		menuMgr = top.Ext.menu.MenuMgr;
		if(menuMgr) {
			menuMgr.hideAll();
		}
	} catch (e) {}
}
//body添加click事件处理
var doc = window.document;
doc.onclick=hideMainMenu;
</script>
</head>
<body background="resources/images/waiter.jpg">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" align="center" >
  <tr>
    
  </tr>
</table>  
</body>
</html>