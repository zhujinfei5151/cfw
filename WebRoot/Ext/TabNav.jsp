<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head.jsp" />
<script type="text/javascript" src="Ext/org/cfw/view/TabNav.js"></script>
<script type="text/javascript" src="Ext/org/cfw/control/TabNav.js"></script>
<title>通用信息系统框架</title>
<script type="text/javascript">
//菜单加载
var tabs;
var tabStr  = '[{"text":"通道设置","menu":[],"isShared":"","type":"1","iconCls":"","url":"demo/channel.jsp","handler":"","menuID":"11020100"},'
              + '{"text":"计算方案设置","menu":[],"active":"1","isShared":"","type":"1","iconCls":"","url":"demo/calcScheme.jsp","handler":"","menuID":"11020200"}]';
if(!Ext.isEmpty(tabStr)) {
	tabs = Ext.decode(tabStr);
}
</script>
</head>
<body>
</body>
</html>