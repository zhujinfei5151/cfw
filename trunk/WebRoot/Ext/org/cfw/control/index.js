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
	modifyAccountBtn.on('click', onModifyAccount);
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
								menuid : thirdMenuItem.moduleid,
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
							menuid : subMenuItem.moduleid,
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
							menuid : subMenuItem.moduleid,
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
					menuid : menuItem.moduleid,
					text : menuItem.text,
					type : menuItem.type,
					iconCls : menuItem.iconCls,
					menu : subMenu
				});
			} else {
				// 一级菜单
				menubar.add({
					menuid : menuItem.moduleid,
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
	var timestamp = Date.UTC(new Date());
	moduleLoader.src = item.url + "?moduleid=" + item.menuid + "&timestamp=" + timestamp;
	
}

function onThemeComboChange(field,newValue,oldValue,options) {
    currentPath = window.location.pathname,
    isCurrent = currentPath.match(newValue);
	if (!isCurrent) {
	    window.location = newValue;
	}
}
var modifyPasswordWindow;
function onModifyAccount(){
	modifyPasswordWindow = new cfw.sys.view.ModifyPasswordWindow();
	modifyPasswordWindow.show();//该修改密码页面只有在点击“修改”按钮的时候才显示
	
	var modifyButton=Ext.getCmp('modify');
	modifyButton.on('click',modifyPsw);
	
	var cancelButton=Ext.getCmp('cancel');
	cancelButton.on('click',cancelPsw);
}

function modifyPsw(){
	var form = Ext.getCmp("modifypasswordform").getForm();
	if(!form.isValid()){//isValid--是正当的，有效的  
		showWarningDialog("表单确认失败！");
		return;
	}	
	
	var pass1 = form.findField("newpassword").getValue();//findField()括号里填的是name值
	var pass2 = form.findField("newpassword2").getValue();
	var oldPass = form.findField("oldpassword").getValue();

	//密码检测
	if (Ext.isEmpty(oldPass) && Ext.isEmpty(pass1) && Ext.isEmpty(pass2)){

	}else if (!Ext.isEmpty(oldPass) && !Ext.isEmpty(pass1) && !Ext.isEmpty(pass2)){
		if (pass1 != pass2){
			showErrorDialog("两次新密码输入不一致!");
			form.findField("newpassword").reset();
			form.findField("newpassword2").reset();
			return;
		}
	}else{
		showErrorDialog("原密码和新密码都不能为空!");
		return;
	}		

	Ext.Ajax.request({//异步加载
		url : "sys/accounts_modifyPassword.action",	
		params : {//给action赋值
			'oldpassword' : oldPass,
			'newpassword' : pass1,
			'newpassword2' : pass2
		},
		method : 'post',
		success : function(response, options) {
			var res = Ext.decode(response.responseText);//将json数据转为js脚本
			if (res.success){
				showInfoDialog("密码修改成功！");
				//Ext.getCmp("passwordform").close();
				modifyPasswordWindow.close();
			}else{
				showErrorDialog(res.errorMsg);					
			}				
		},
		failure : function() {
			showErrorDialog("提交失败！");
		}		
	});		 
}

function cancelPsw(){
	modifyPasswordWindow.close();
}