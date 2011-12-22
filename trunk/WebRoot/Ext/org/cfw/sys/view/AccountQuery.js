Ext.define('cfw.sys.view.ui.AccountQueryViewport',{
	extend : 'Ext.container.Viewport',
	initComponent : function(){
		this.accountQueryStore = new cfw.sys.store.AccountQueryStore();
		this.accountQueryGrid = Ext.create('Ext.grid.Panel', {
			id : 'accountQueryGrid',
			store : this.accountQueryStore,
			region : 'center',
			tbar : Ext.create('Ext.toolbar.Toolbar', {
             items : [{
				text : "用户帐号",
				xtype : 'tbtext'
			},{
				xtype : 'textfield',
				name : 'account',
				id : 'account',
				emptyText : "所有"
			},"",{
				text : "用户名称",
				xtype : 'tbtext'
			},{
				xtype : 'textfield',
				name : 'name',
				id : 'name',
				emptyText : "所有"
			},"->",{
				text : '查询',
				xtype : 'button',
				name : 'queryButton',
				id : 'queryButton'
			}]}),
			columns : [{
				text : "用户帐号",
				dataIndex : 'account',
				sortable : true
			},{
				text : "用户名称",
				dataIndex : 'name',
				sortable : true
			},{
				text : "所属角色",
				dataIndex : 'roledesc',
				sortable : true
			},{
				text : "创建者",
				dataIndex : 'createaccount',
				sortable : true
			},{
				text : "创建时间",
				dataIndex : 'createtime',
				sortable : true,
				renderer : Ext.util.Format.dateRenderer('Y-m-d h:m:s'),
				width : 140
			}],
			dockedItems: [{
		           xtype: 'pagingtoolbar',
		           store: this.accountQueryStore, 
		           dock: 'bottom',
		           displayInfo: true,
		           displayMsg : '第 {0} - {1} 条 共 {2} 条',
		           emptyMsg : "没有记录",
		           pageSize : limit,
		           listeners : {
						change : function(paging,pageData) {
							start = (pageData.activePage-1) * limit;
							total = pageData.total;				
						}
					}
		       }]

		});
		
		var limit = 20;
		
		Ext.apply(this,{
			headerAsText : true,
			layout : 'border',
			items : [this.accountQueryGrid]
		});
		this.callParent(arguments);
	}
});