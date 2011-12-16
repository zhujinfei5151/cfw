Ext.define('cfw.sys.model.Account',{
	extend:'Ext.data.Model',
	fields:['account','name','sex','roleid','position','createaccount',{
		name:'createtime',
		type:'date',
		//mapping : "createtime",
		dateFormat:'Y-m-dTH:i:s'
	},'note']
});