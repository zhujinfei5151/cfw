

Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.view.ui.MenuTreeNav({
		renderTo : Ext.getBody()
	});
	vp.show();
	
	init();
});

function init() {
	var funcTree = Ext.getCmp("funcTree");
	
	funcTree.on('itemclick', onItemClick);
	
	//自动加载欢迎页面
	var tabpanel = Ext.getCmp('tabpanel');
	var tab = tabpanel.add({
		title : '欢迎',
		url : WELCOME_URL,
		listeners : {
			'activate' : onActive
		}
	});
	tabpanel.setActiveTab(tab);
}

function onItemClick(view, record){
	var tabpanel = Ext.getCmp('tabpanel');
	tabpanel.removeAll();
	var tab = tabpanel.add({
		title : record.raw.text,
		url : record.raw.url,
		listeners : {
			'activate' : onActive
		}
	});
	tabpanel.setActiveTab(tab);
}

function onActive(comp, option) {
	var subModuleLoader = Ext.get('subModuleLoader').dom;
	subModuleLoader.src = comp.url;
}