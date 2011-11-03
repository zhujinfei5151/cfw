Ext.define('cfw.view.ui.MenuTreeNav', {
	extend : 'Ext.container.Viewport',

	layout : {
		type : 'border'
	},

	initComponent : function() {
		var me = this;
		var html = '<iframe id="subModuleLoader" width="100%" '
				+ 'height="100%" frameborder="0" '
				+ 'scrolling="auto"></iframe>';
		Ext.applyIf(me, {
			items : [ {
				xtype : 'tabpanel',
				id : 'tabpanel',
				activeTab : 0,
				region : 'center',
				html : html
			}, {
				xtype : 'treepanel',
				id : 'funcTree',
				width : 150,
				title : '功能菜单',
				region : 'west',
				split : true,
				border : false,
				collapsible : true,
				collapsieMode : 'header',
				rootVisible : false,
				viewConfig : {

				},
				store : new cfw.store.FuncTreeStore()
			} ]
		});

		me.callParent(arguments);
	}
});