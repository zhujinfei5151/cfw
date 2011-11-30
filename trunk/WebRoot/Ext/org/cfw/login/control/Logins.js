Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var loginWindow = new cfw.login.view.Login();
	loginWindow.show();
	
	init();
});

function init() {
	var loginButton = Ext.getCmp("loginButton");
	loginButton.on('click',loginUser);
	
	var resetButton = Ext.getCmp("resetButton");
	resetButton.on('click',resetUser);
	
}

function loginUser() {
	var form = Ext.getCmp("form");
	if(form.getForm().isValid()){
		form.getForm().submit({
			method:"post",
			url:"login.action",
			waitMsg:"请稍等，正在登录...",
			waitTitle:"正在验证",
			success:function(form,action){
				window.location.href='/cfw/Ext/index.jsp';
				Ext.Msg.alert("登录成功",action.result.msg);
			},
			failure:function(form,action){
			    resetUser();
			 	Ext.Msg.alert("登录失败",action.result.msg);
			}
		})
	}
	
}

function resetUser(){
	var form = Ext.getCmp("form");
	form.getForm().reset();
}



