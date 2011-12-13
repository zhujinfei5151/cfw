Ext.define('cfw.sys.view.ModifyPasswordWindow', {
	extend : 'Ext.window.Window',
	alias : 'widget.modifypasswordwindow',
	id : 'modifypasswordwindow',
	height : 170,
	width : 270,
	layout : {
		type : 'fit'
	},
	title : '密码修改',

	initComponent : function() {
		var me = this;

		Ext.applyIf(me, {
			items : [ {
				id : 'modifypasswordform',
				xtype : 'form',
				frame : true,
				fieldDefaults : {
					labelWidth : 80,
			        labelAlign: 'right'
				},
				bodyPadding : 10,
				items : [ {
					xtype : 'textfield',
					id:'oldpassword',
					name:'oldpassword',
					fieldLabel : '旧密码',
					blankText : '不能为空',//提示信息不能为空
					allowBlank : false,
					anchor : '100%',
					inputType : 'password'
				}, {
					xtype : 'textfield',
					id:'newpassword',
					name:'newpassword',
					fieldLabel : '新密码',
					blankText : '不能为空',
					allowBlank : false,
					anchor : '100%',
					inputType : 'password'
				}, {
					xtype : 'textfield',
					id:'newpassword2',
					name:'newpassword2',
					allowBlank : false,
					blankText : '不能为空',
					fieldLabel : '重新输一次',
					anchor : '100%',
					inputType : 'password'
				}],
				buttons : [{
					text : '修改',
					id:'modify'
				},{
					text : '取消',
					id : 'cancel'
				}]
			} ]
		});
		me.callParent(arguments);
	}
});