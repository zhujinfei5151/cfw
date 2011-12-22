Ext.define('cfw.sys.view.ui.RolesViewport', {//该路径与control里的new有关(var vp = new cfw.sys.view.ui.RolesViewport({)
	extend : 'Ext.container.Viewport',

	layout : {
		type : 'border'
	},
	
	initComponent : function() {
		var me = this;
		var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
			clicksToEdit : 1
		});
		Ext.applyIf(me, {
			items : [ {
				xtype : 'panel',
				layout : {
					type : 'border'
				},
				region : 'center',
				items : [ {
					xtype : 'treepanel',
					id : 'modulegrid',
					title : '系统功能',
					width : 400,
					useArrows : true,
					store : new cfw.sys.store.MenuStore(),
					rootVisible : false,
					singleExpand : false,
					region : 'center',
					columns : [{
						xtype : 'treecolumn',
						text : '功能名称',
						dataIndex : 'text',
						width : 150
					},{
						text : '操作',
						width : 130,
						dataIndex : 'mask',
						renderer : this.renderMask,
						editor : {
							xtype : 'combobox',
							align : 'center',
							width : 100,
							triggerAction : 'all',
							displayField : 'field1',
							valueField : 'field2',
							editable : false,
							queryStore : Ext.create('cfw.sys.store.MaskStore'),
							store : [[0,'禁用']],
							listeners : {
								'beforequery' : function(queryEvent,options){
									var node = Ext.getCmp('modulegrid').getSelectionModel().selected.items[0];
									var mask = node.data.maxmask;
									var maxmask = 0;
									var minmask = 3;
									if(!node.data.leaf){
										var children = node.childNodes;
										var flag = false;
										var itemmaxmask;
										Ext.Array.each(children,function(itemNode){
											itemmaxmask = itemNode.data.maxmask;
											if(itemmaxmask > maxmask){
												maxmask = itemmaxmask;
											}
											if(itemNode.data.mask > 0){
												flag = true;
												if(itemmaxmask < minmask){
													minmask = itemmaxmask;
												}
											}
										});
										if(flag){
											mask = minmask;
										}else{
											mask = maxmask;
										}
										node.data.maxmask = mask;
									}
									
									
									var tempstore = Ext.clone(this.queryStore);
									tempstore.filterBy(function(record){
										if(record.get('value') <= mask)return true;
										else return false;
									});
									var records = tempstore.data;
									this.store.removeAll();
									for(var i=0;i<records.length;i++) {
										var record = records.getAt(i).data;
										this.store.add({'field1':record.value, 'field2':record.display});
									}
								}
							}
						}
					}],
					selModel : ['cellmodel'],
					plugins : [cellEditing]
				}, {
					xtype : 'form',
					id : 'moduleform',
					frame : true,
					height : 120,
					layout : {
						type : 'auto'
					},
					bodyPadding : 10,
					title : '',
					region : 'north',
					items : [{
						xtype : 'textfield',
						id : 'name',
						width : 200,
						fieldLabel : '名称',
						labelAlign : 'right',
						labelWidth : 60,
						anchor : '100%'
					}, {
						xtype : 'textfield',
						id : 'rolecomment',
						width : 400,
						anchor : '100%',
						fieldLabel : '备注',
						labelAlign : 'right',
						labelWidth : 60
					}],
					dockedItems : [ {
						xtype : 'toolbar',
						dock : 'top',
						items : [ {
							xtype : 'button',
							text : '增 加',
							action : 'add'
						}, {
							xtype : 'button',
							text : '修 改',
							action : 'modify'
						}, {
							xtype : 'button',
							text : '删 除',
							action : 'remove'
						} ]
					} ]
				} ]
			}, {
				xtype : 'gridpanel',
				id : 'rolegrid',
				width : 200,
				region : 'west',
				store : new cfw.sys.store.RoleStore(),
				columns : [ {
					xtype : 'gridcolumn',
					width : 80,
					dataIndex : 'name',
					text : '名称'
				} ,{
					xtype : 'gridcolumn',
					flex : 1,
					dataIndex : 'rolecomment',
					text : '备注'
				}],
				selModel : Ext.create('Ext.selection.CheckboxModel', {

				})
			} ]
		});

		me.callParent(arguments);
	},
	renderMask : function(value){
		if(value == undefined) value = 0;
		var display = '';
		var maskstore = new cfw.sys.store.MaskStore();
		maskstore.each(function(record){
			if(record.data.value == value) {
				display = record.data.display;
				return false;
			}
			return true;
		});
		return display;
	}
});
