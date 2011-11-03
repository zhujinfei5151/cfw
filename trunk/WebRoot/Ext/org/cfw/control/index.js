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
		alert('logoutBtn clicked.')
	});
	
	var modifyAccountBtn = Ext.getCmp('modifyAccountBtn');
	modifyAccountBtn.on('click',function(){
		alert('modifyAccountBtn clicked.')
	});
}

function loadMenu() {
	var menubar = Ext.getCmp('menubar');
	menubar.add({
		xtype : 'tbfill'
	});

	if (!Ext.isEmpty(menuItems) && menuItems.length > 0) {
		var length = menuItems.length;
		for ( var i = 0; i < length; i++) {
			var menuItem = menuItems[i];
			if (!Ext.isEmpty(menuItem.menu) && menuItem.menu.length > 0) {
				var subLen = menuItem.menu.length;
				var subMenu = new Ext.menu.Menu();
				// 二级菜单
				for ( var j = 0; j < subLen; j++) {
					var subMenuItem = menuItem.menu[j];
					// 三级菜单
					if (!Ext.isEmpty(subMenuItem.menu)
							&& subMenuItem.menu.length > 0) {
						var thirdLen = subMenuItem.menu.length;
						var thirdMenu = new Ext.menu.Menu();
						for ( var k = 0; k < thirdLen; k++) {
							var thirdMenuItem = subMenuItem.menu[k];
							thirdMenu.add(new Ext.menu.Item({
								id : thirdMenuItem.menuID,
								text : thirdMenuItem.text,
								type : thirdMenuItem.type,
								icon : Ext.BLANK_IMAGE_URL,
								iconCls : thirdMenuItem.iconCls,
								url : thirdMenuItem.url,
								handler : this.onItemClick
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
							handler : this.onItemClick
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
							handler : this.onItemClick
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
	alert(item.text + "|" + item.url);
	var moduleLoader = Ext.get('moduleLoader').dom;
	moduleLoader.src = item.url;
}