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
				id : 'moduleTabPanel',
				activeTab : 0,
				region : 'center',
				html : html
			}, {
				xtype : 'tabpanel',
				id : 'treeTabPanel',
				title : '对象',
				activeTab : 0,
				region : 'west',
				width : 150,
				split : true,
				border : false,
				collapsible : true,
				collapsieMode : 'header',
				items : [{
					xtype : 'treepanel',
					id : 'transTree',
					title : '输电网',
					region : 'west',
					rootVisible : false,
					store : new cfw.store.ObjTreeStore()
				},{
					xtype : 'treepanel',
					id : 'distrTree',
					title : '配电网',
					region : 'west',
					rootVisible : false,
					store : new cfw.store.ObjTreeStore()
				} ]
			}]
		});

		me.callParent(arguments);
	}
});