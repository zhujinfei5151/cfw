Ext.define('cfw.sys.store.AccountQueryStore',{
	extend : 'Ext.data.Store',
	model : 'cfw.sys.model.AccountQuery',
	pageSize : 20, 
	proxy : {
		type : 'ajax',
		url : 'sys/accountQuery_query.action',
		reader : {
			type : 'json',
			root : 'root',
			totalProperty: 'totalProperty'
		}
	}
});