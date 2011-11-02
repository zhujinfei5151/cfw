Ext.define('cfw.view.ui.Viewport', {
	extend : 'Ext.container.Viewport',
	alias : 'widget.cfwviewport',
	layout : {
		type : 'border'
	},

	initComponent : function() {
		var me = this;
		var html = '<iframe id="moduleLoader" width="100%" '
				+ 'height="100%" frameborder="0" '
				+ 'scrolling="auto" src="Ext/welcome.jsp" ></iframe>';
		Ext.applyIf(me, {
			items : [ {
				xtype : 'panel',
				region : 'center',
				dockedItems : [ {
					xtype : 'toolbar',
					dock : 'bottom',
					items : [ {
						xtype : 'tbspacer',
						width : 10
					}, {
						xtype : 'label',
						text : '用户名:admin'
					}, {
						xtype : 'tbseparator'
					}, {
						xtype : 'button',
						text : '修 改',
						id : 'modifyAccountBtn'
					} ]
				} ],
				html : html
			}, {
				xtype : 'panel',
				height : 90,
				layout : {
					type : 'border'
				},
				region : 'north',
				dockedItems : [ {
					xtype : 'toolbar',
					region : 'center',
					dock : 'bottom',
					id : 'menubar',
					height : 25
				} ],
				items : [ {
					xtype : 'container',
					region : 'center'
				}, {
					xtype : 'panel',
					width : 160,
					region : 'east',
					dockedItems : [ {
						xtype : 'toolbar',
						dock : 'bottom',
						items : [ {
							xtype : 'button',
							text : '首 页',
							id : 'homepageBtn'
						}, {
							xtype : 'tbseparator'
						}, {
							xtype : 'button',
							text : '帮 助',
							id : 'helpBtn'
						}, {
							xtype : 'tbseparator'
						}, {
							xtype : 'button',
							text : '注 销',
							id : 'logoutBtn'
						} ]
					} ]
				} ]
			} ]
		});

		me.callParent(arguments);
	}
});