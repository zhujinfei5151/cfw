Ext.define('cfw.login.view.Login', {
	extend : 'Ext.window.Window',
	alias : 'widget.loginForm',
	requires : [ 'Ext.form.*', 'cfw.login.view.CheckCode' ],
	initComponent : function() {
		var checkcode = Ext.create('cfw.login.view.CheckCode', {
			cls : 'CheckCode',
			fieldLabel : '验证码',
			name : 'checkcode',
			id : 'checkcode',
			allowBlank : false,
			isLoader : true,
			blankText : '验证码不能为空',
			codeUrl : 'checkcode_init.action',
			width : 160,
			height : 23
		});
		var form = Ext.widget('form', {
			id : 'form',
			border : false,
			bodyPadding : 10,
			fieldDefaults : {
				labelAlign : 'left',
				labelWidth : 55,
				labelStyle : 'font-weight:bold'
			},
			defaults : {
				margins : '0 0 10 0'
			},
			items : [ {
				xtype : 'textfield',
				id : 'username',
				name : 'username',
				fieldLabel : '用户名',
				blankText : '用户名不能为空',
				allowBlank : false,
				width : 240
			}, {
				xtype : 'textfield',
				id : 'password',
				name : 'password',
				fieldLabel : '密&nbsp;&nbsp;&nbsp;码',
				allowBlank : false,
				blankText : '密码不能为空',
				width : 240,
				inputType : 'password'
			}, checkcode ],
			buttons : [ {
				text : '登录',
				id : "loginButton"
			}, {
				text : '重置',
				id : 'resetButton'
			} ]
		});

		Ext.apply(this, {
			height : 200,
			width : 300,
			title : '用户登录',
			closeAction : 'hide',
			closable : false,
			layout : 'fit',
			modal : true,
			plain : true,
			resizable : false,
			items : form,
			bbar : Ext.create('Ext.Toolbar', {
				id : 'login-status',
				height : 23,
				items : [ {
					xtype : 'label',
					id : 'errinfoLabel',
					cls : 'redfont'
				} ]
			})
		});

		this.callParent(arguments);
	}
});