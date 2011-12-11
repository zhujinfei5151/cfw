Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.view.ui.Viewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	
	init();
	loadMenu();//载入菜单
});

function init() {
	var homepageBtn = Ext.getCmp('homepageBtn');
	var helpBtn = Ext.getCmp('helpBtn');
	var logoutBtn = Ext.getCmp('logoutBtn');
	
	homepageBtn.on('click',function(){
		alert('homepageBtn clicked.')
	});
	helpBtn.on('click',function(){
		alert('helpBtn clicked.')
	});
	logoutBtn.on('click',function(){
		window.location.href = 'logout.action';
	});
	
	var modifyAccountBtn = Ext.getCmp('modifyAccountBtn');
	modifyAccountBtn.on('click',function(){
		alert('modifyAccountBtn clicked.')
	});
	
	var themeCombo = Ext.getCmp("themeCombo");
	themeCombo.on('change',onThemeComboChange);
	if(currentTheme == 'ext-all') {
		themeCombo.setValue('index.action');
	} else if(currentTheme == 'ext-all-gray') {
		themeCombo.setValue('index_gray.action');
	} else if(currentTheme == 'ext-all-access') {
		themeCombo.setValue('index_access.action');
	} else {
		themeCombo.setValue('index.action');
	}
}

function loadMenu() {
	var menuStore = new cfw.store.MenuStore();
	menuStore.load({callback:onLoadMenu});
}

function onLoadMenu(menuItems) {
	var menubar = Ext.getCmp('menubar');
	menubar.add({
		xtype : 'tbfill'
	});

	if (!Ext.isEmpty(menuItems) && menuItems.length > 0) {
		var length = menuItems.length;
		for ( var i = 0; i < length; i++) {
			var menuItem = menuItems[i].data;
			if (!Ext.isEmpty(menuItem.menus) && menuItem.menus.length > 0) {
				var subLen = menuItem.menus.length;
				var subMenu = new Ext.menu.Menu();
				// 二级菜单
				for ( var j = 0; j < subLen; j++) {
					var subMenuItem = menuItem.menus[j];
					// 三级菜单
					if (!Ext.isEmpty(subMenuItem.menus)
							&& subMenuItem.menus.length > 0) {
						var thirdLen = subMenuItem.menus.length;
						var thirdMenu = new Ext.menu.Menu();
						for ( var k = 0; k < thirdLen; k++) {
							var thirdMenuItem = subMenuItem.menus[k];
							thirdMenu.add(new Ext.menu.Item({
								id : thirdMenuItem.menuID,
								text : thirdMenuItem.text,
								type : thirdMenuItem.type,
								icon : Ext.BLANK_IMAGE_URL,
								iconCls : thirdMenuItem.iconCls,
								url : thirdMenuItem.url,
								handler : onItemClick
							}));
						}
						// 二级菜单
						subMenu.add(new Ext.menu.Item({
							id : subMenuItem.menuID,
							text : subMenuItem.text,
							type : subMenuItem.type,
							icon : Ext.BLANK_IMAGE_URL,
							iconCls : subMenuItem.iconCls,
							url : subMenuItem.url,
							menu : thirdMenu,
							handler : onItemClick
						}));
					} else {
						// 二级菜单
						subMenu.add(new Ext.menu.Item({
							id : subMenuItem.menuID,
							text : subMenuItem.text,
							type : subMenuItem.type,
							icon : Ext.BLANK_IMAGE_URL,
							iconCls : subMenuItem.iconCls,
							url : subMenuItem.url,
							handler : onItemClick
						}));
					}
				}
				// 一级菜单
				menubar.add({
					id : menuItem.menuID,
					text : menuItem.text,
					type : menuItem.type,
					iconCls : menuItem.iconCls,
					menu : subMenu
				});
			} else {
				// 一级菜单
				menubar.add({
					id : menuItem.menuID,
					text : menuItem.text,
					type : menuItem.type,
					iconCls : menuItem.iconCls
				});
			}
		}
	}
}

function onItemClick(item) {
	var moduleLoader = Ext.get('moduleLoader').dom;
	moduleLoader.src = item.url;
}

function onThemeComboChange(field,newValue,oldValue,options) {
    currentPath = window.location.pathname,
    isCurrent = currentPath.match(newValue);
	if (!isCurrent) {
	    window.location = newValue;
	}
}