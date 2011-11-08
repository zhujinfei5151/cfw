Ext.define('cfw.sys.view.ui.RolesViewport', {
	extend : 'Ext.container.Viewport',

	layout : {
		type : 'border'
	},

	initComponent : function() {
		var me = this;

		Ext.applyIf(me, {
			items : [ {
				xtype : 'panel',
				layout : {
					type : 'border'
				},
				region : 'center',
				items : [ {
					xtype : 'gridpanel',
					title : '功能权限分配',
					region : 'center',
					columns : [ {
						xtype : 'gridcolumn',
						width : 132,
						dataIndex : 'string',
						text : 'String'
					}, {
						xtype : 'booleancolumn',
						dataIndex : 'bool',
						text : 'Boolean'
					} ]
				}, {
					xtype : 'form',
					height : 77,
					layout : {
						type : 'auto'
					},
					bodyPadding : 10,
					title : '',
					region : 'north',
					items : [ {
						xtype : 'textfield',
						width : 200,
						fieldLabel : '名称',
						labelAlign : 'right',
						labelWidth : 60,
						anchor : '100%'
					} ],
					dockedItems : [ {
						xtype : 'toolbar',
						dock : 'top',
						items : [ {
							xtype : 'button',
							text : '增 加'
						}, {
							xtype : 'button',
							text : '修 改'
						}, {
							xtype : 'button',
							text : '删 除'
						} ]
					} ]
				} ]
			}, {
				xtype : 'gridpanel',
				width : 200,
				region : 'west',
				columns : [ {
					xtype : 'gridcolumn',
					width : 160,
					dataIndex : 'string',
					text : '名称'
				} ],
				viewConfig : {

				},
				selModel : Ext.create('Ext.selection.CheckboxModel', {

				})
			} ]
		});

		me.callParent(arguments);
	}
});