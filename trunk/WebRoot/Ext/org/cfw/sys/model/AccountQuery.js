Ext.define('cfw.sys.model.AccountQuery',{
	extend:'Ext.data.Model',
	fields:['account','name','sex','roleid','roledesc','position','createaccount',{
		name:'createtime',
		type:'date',
		//mapping : "createtime",
		dateFormat:'Y-m-dTH:i:s'
	},'note']
});