Ext.define('cfw.view.ui.TabNav', {
	extend : 'Ext.container.Viewport',

	layout : {
		type : 'fit'
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
			}]
		});

		me.callParent(arguments);
	}
});