Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.sys.view.ui.AccountQueryViewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	init();
});


var accountQueryGrid;
var limit = 20;
var start;
function init(){
	accountQueryGrid = Ext.getCmp('accountQueryGrid');
	var store = accountQueryGrid.getStore();
	store.load();
	store.on('beforeload',beforeQueryAccount)
	
	var queryButton = Ext.getCmp("queryButton");
	queryButton.on('click',queryAccount);
}

function queryAccount(){
	accountQueryGrid.getStore().load({params : {start : 0,limit : limit}});
}

function beforeQueryAccount(store,operation,options) {
	var account = Ext.getCmp("account").getValue();
	var name = Ext.getCmp("name").getValue();
	store.proxy.extraParams = {account : account,name : name}; 
}