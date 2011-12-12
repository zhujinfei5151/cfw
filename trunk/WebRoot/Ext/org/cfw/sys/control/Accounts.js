Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.sys.view.ui.AccountsViewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	
	init();
});

var accountgrid;
function init(){
	accountgrid = Ext.getCmp('accountgrid');
	var store = accountgrid.getStore();
	store.load();
	
//	var sexcombo = Ext.getCmp('sexcombo');
//	var sexstore = sexcombo.store;
//	sexstore.load();
	
	var combo = Ext.getCmp('comboid');
	var rolestore = combo.store;
	rolestore.load();
	
	var sm =accountgrid.getSelectionModel();
	sm.addListener("selectionchange",function(model,records) {
		if(records[0]){
			Ext.getCmp('accountForm').getForm().loadRecord(records[0]);
		} 
	});
	
	var addButton = Ext.getCmp("addButton");
	addButton.on('click',addAccount);
//	
//	var modifyButton = Ext.getCmp("modifyButton");
//	modifyButton.on('click',modifyAccount);
//	
//	var deleteButton = Ext.getCmp("deleteButton");
//	deleteButton.on('click',deleteAccount);
}

function addAccount(){
	var accountForm = Ext.getCmp("accountForm").getForm();
	if(!accountForm.isValid()) return;
	Ext.Ajax.request({
		url : 'sys/account_add.action',
		params:{
			account : accountForm.findField("account").getValue(),
			name : accountForm.findField("name").getValue(),
			sex : accountForm.findField("sex").getValue(),
			roleid : accountForm.findField("roleid").getValue(),
			position : accountForm.findField("position").getValue(),
			note : accountForm.findField("note").getValue(),
		},
		success : function(response,options){
			accountgrid.getStore().load();
			accountForm.reset();
		},
		failure : function() {
			Ext.Msg.show({
				title : '错误提示',
				msg : '增加帐号失败,请重试!',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}
