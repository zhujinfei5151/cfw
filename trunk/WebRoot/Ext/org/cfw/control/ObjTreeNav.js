

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
	var transTree = Ext.getCmp("transTree");
	var distrTree = Ext.getCmp("distrTree");
	
	transTree.on('itemclick', onItemClick);
	distrTree.on('itemclick', onItemClick);
	
	//自动加载欢迎页面
	var moduleTabPanel = Ext.getCmp('moduleTabPanel');
	var tab = Ext.create('Ext.tab.Tab',{
		title : '隐藏',
		hidden : true
	});
	moduleTabPanel.add(tab);
	tab = moduleTabPanel.add({
		title : '欢迎',
		url : WELCOME_URL,
		listeners : {
			'activate' : onActive
		}
	});
	moduleTabPanel.setActiveTab(tab);
}

function onItemClick(view, record){
	var moduleTabPanel = Ext.getCmp('moduleTabPanel');
	moduleTabPanel.removeAll();
	var tab = Ext.create('Ext.tab.Tab',{
		title : '隐藏',
		hidden : true
	});
	moduleTabPanel.add(tab);
	tab = moduleTabPanel.add({
		title : record.raw.text,
		url : record.raw.url,
		listeners : {
			'activate' : onActive
		}
	});
	moduleTabPanel.setActiveTab(tab);
}

function onActive(comp, option) {
	var subModuleLoader = Ext.get('subModuleLoader').dom;
	subModuleLoader.src = comp.url;
}