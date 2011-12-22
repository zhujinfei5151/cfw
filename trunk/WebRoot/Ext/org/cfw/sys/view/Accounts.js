Ext.define('cfw.sys.view.ui.AccountsViewport', {
	extend : 'Ext.container.Viewport',
	initComponent : function() {
		this.accountGrid = Ext.create('Ext.grid.Panel', {
			id : 'accountgrid',
			autoScroll : true,
			store : new cfw.sys.store.AccountStore(),
			region : 'center',
			layout : 'fit',
			columns : [ {
				text : "用户帐号",
				dataIndex : 'account',
				sortable : true
			}, {
				text : "用户名称",
				dataIndex : 'name',
				sortable : true
			}, {
				text : "用户性别",
				dataIndex : 'sex',
				sortable : true,
				renderer : function(value) {
					var sexcombo = Ext.getCmp('sexcombo').store;
					var desc;
					sexcombo.each(function(model) {
						if (model.get('sex') == value) {
							desc = model.get('desc');
							return false;
						}
					});
					return desc;
				}
			}, {
				text : "所属角色",
				dataIndex : 'roleid',
				sortable : true,
				renderer : function(value) {
					var combobox = Ext.getCmp('comboid').store;
					var name;
					combobox.each(function(model) {
						if (model.get('roleid') == value) {
							name = model.get('name');
							return false;
						}
					});
					return name;
				}
			}, {
				text : "职务",
				dataIndex : 'position',
				sortable : true
			}, {
				text : "创建者",
				dataIndex : 'createaccount',
				sortable : true
			}, {
				text : "创建时间",
				dataIndex : 'createtime',
				sortable : true,
				renderer : Ext.util.Format.dateRenderer('Y-m-d h:m:s'),
				width : 140
			}, {
				text : "备注",
				dataIndex : 'note',
				sortable : true
			} ],
			selModel : Ext.create('Ext.selection.CheckboxModel', {
				mode : 'SINGLE',
				allowDeselect : true
			})
		});
		this.roleStore = new cfw.sys.store.AccountFormRoleStore();
		this.accountForm = Ext.widget('form', {
			id : 'accountForm',
			region : 'south',
			height : 220,
			frame : true,
			bodyStyle : 'padding-top:5px',
			labelWidth : 60,
			defaults : {
				labelAlign : 'right'
			},
			items : [ {
				fieldLabel : "用户名",
				name : 'account',
				xtype : 'textfield',
				allowBlank : false,
				blankText : "用户名不能为空!"
			}, {
				fieldLabel : "用户姓名",
				name : 'name',
				xtype : 'textfield',
				allowBlank : false,
				blankText : "用户姓名不能为空!"
			}, {
				fieldLabel : "用户性别",
				id : 'sexcombo',
				name : 'sex',
				xtype : 'combo',
				valueField : 'sex',
				displayField : 'desc',
				mode : 'local',
				store : new cfw.sys.store.SexStore(),
				triggerAction : 'all',
				emptyText : "请选择性别...",
				allowBlank : false,
				blankText : "用户性别不能为空!"
			}, {
				fieldLabel : "所属角色",
				id : 'comboid',
				name : "roleid",
				xtype : "combo",
				valueField : 'roleid',
				displayField : 'name',
				mode : 'local',
				store : this.roleStore,
				triggerAction : 'all',
				emptyText : "请选择所属角色...",
				allowBlank : false,
				blankText : "所属角色不能为空!"
			}, {
				fieldLabel : "职务",
				name : 'position',
				xtype : 'textfield'
			}, {
				fieldLabel : "备注",
				name : 'note',
				xtype : 'textfield'
			} ],
			buttons : [ {
				text : "增 加",
				id : 'addButton'
			}, {
				text : "修 改",
				id : 'modifyButton'
			}, {
				text : "删 除",
				id : 'deleteButton'
			} ],
			buttonAlign : 'left'

		});

		Ext.apply(this, {
			headerAsText : true,
			layout : 'border',
			bodyStyle : 'padding:5px 5px 5px 5px;',
			items : [ this.accountForm, this.accountGrid ]
		});
		this.callParent(arguments);
	}
})