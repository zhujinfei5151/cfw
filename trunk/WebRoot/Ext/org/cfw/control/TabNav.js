
Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.view.ui.TabNav({
		renderTo : Ext.getBody()
	});
	vp.show();

	init();
});

function init() {
	// 自动加载菜单
	var tabpanel = Ext.getCmp('tabpanel');
	if (!Ext.isEmpty(tabs) && tabs.length > 0) {
		var length = tabs.length;
		for ( var i = 0; i < length; i++) {
			var tab = tabs[i];
			// 模块菜单
			var curTab = tabpanel.add({
				id : tab.menuID,
				title : tab.text,
				autoScroll : true,
				url : tab.url,
				listeners : {
					'activate' : onActive
				}
			});

			if(tab.active == '1') {
				tabpanel.setActiveTab(curTab);
			}
		}
	} else {
		tabPanel.add({id:'welcome', title: '欢迎'});
		tabPanel.activate("welcome");
		loadModule(WELCOME_URL);
	}
}

function onActive(comp, option) {
	loadModule(comp.url);
}

function loadModule(url) {
	var subModuleLoader = Ext.get('subModuleLoader').dom;
	subModuleLoader.src = url;
}