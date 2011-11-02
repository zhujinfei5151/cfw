<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head.jsp" />
<script type="text/javascript" src="Ext/org/cfw/view/Viewport.js"></script>
<script type="text/javascript" src="Ext/org/cfw/control/index.js"></script>
<title>通用信息系统框架</title>
<script type="text/javascript">
//菜单加载
var menuItems;
var menuItemsStr  = '[{"text":"运行管理","menu":[{"text":"档案管理","menu":[],"isShared":"","type":"1","iconCls":"","url":"frameObjTree.jsp","handler":"","menuID":"11010000"},{"text":"参数设置","menu":[],"isShared":"","type":"1","iconCls":"","url":"frameTab.jsp","handler":"","menuID":"11020000"},{"text":"异常查询","menu":[],"isShared":"","type":"1","iconCls":"","url":"frameFuncTree.jsp","handler":"","menuID":"11050000"},{"text":"运行工况","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"11040000"},{"text":"计量维护","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"11030000"}],"isShared":"","type":"0","iconCls":"cssz","url":" ","handler":"","menuID":"11000000"},{"text":"现场管理","menu":[{"text":"数据召读","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12070000"},{"text":"测量点配置","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12020000"},{"text":"任务配置","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12040000"},{"text":"有序用电","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12050000"},{"text":"终端配置","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12010000"},{"text":"总加组配置","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"12030000"}],"isShared":"","type":"0","iconCls":"yxwh","url":" ","handler":"","menuID":"12000000"},{"text":"统计查询","menu":[{"text":"数据查询","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"13010000"},{"text":"负荷分析","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"13030000"},{"text":"电量分析","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"13020000"}],"isShared":"","type":"0","iconCls":"fhfx","url":" ","handler":"","menuID":"13000000"},{"text":"高级功能","menu":[{"text":"预付费管理","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action?treeTypeList=6,3","handler":"","menuID":"14010000"},{"text":"线损分析","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"14020000"},{"text":"优质用电","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"14050000"},{"text":"供电质量","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"14040000"},{"text":"错峰管理","menu":[],"isShared":"","type":"1","iconCls":"","url":"home_para.action","handler":"","menuID":"14030000"}],"isShared":"","type":"0","iconCls":"xsgl","url":" ","handler":"","menuID":"14000000"},{"text":"系统管理","menu":[{"text":"权限管理","menu":[],"isShared":"","type":"1","iconCls":" ","url":"home_demo.action","handler":"","menuID":"01010000"},{"text":"节点配置","menu":[],"isShared":"","type":"1","iconCls":" ","url":"home_thirdTab.action","handler":"","menuID":"01030000"},{"text":"日志查询","menu":[],"isShared":"","type":"1","iconCls":" ","url":"home_thirdTab.action","handler":"","menuID":"01020000"}],"isShared":"","type":"0","iconCls":"xtgl","url":" ","handler":"","menuID":"01000000"}]';
if(!Ext.isEmpty(menuItemsStr)) {
	menuItems = Ext.decode(menuItemsStr);
}	
</script>
</head>
<body>
</body>
</html>