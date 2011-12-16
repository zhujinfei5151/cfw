Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.sys.view.ui.AccountsViewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	vp.roleStore.load();
	init();
});

var accountgrid;
function init(){
	accountgrid = Ext.getCmp('accountgrid');
	var store = accountgrid.getStore();
	store.load();
	
	var combo = Ext.getCmp('comboid');
	var rolestore = combo.store;
	rolestore.load();
	
	var sm =accountgrid.getSelectionModel();
	sm.addListener("selectionchange",function(model,records) {
		var accountForm = Ext.getCmp('accountForm').getForm();
		if(records[0]){
			var accountField = accountForm.findField("account");
			accountField.setDisabled(true);
			accountForm.loadRecord(records[0]);
		} else{
			clearForm();
		}
	});
	
	var addButton = Ext.getCmp("addButton");
	addButton.on('click',addAccount);
	
	var modifyButton = Ext.getCmp("modifyButton");
	modifyButton.on('click',modifyAccount);
	
	var deleteButton = Ext.getCmp("deleteButton");
	deleteButton.on('click',deleteAccount);
}

function addAccount(){
	var accountForm = Ext.getCmp("accountForm").getForm();
	if(!accountForm.isValid()) return;
	Ext.Ajax.request({
		url : 'sys/accounts_add.action',
		params:{
			account : accountForm.findField("account").getValue(),
			name : accountForm.findField("name").getValue(),
			sex : accountForm.findField("sex").getValue(),
			roleid : accountForm.findField("roleid").getValue(),
			position : accountForm.findField("position").getValue(),
			note : accountForm.findField("note").getValue()
		},
		success : function(response,options){
				var res = Ext.decode(response.responseText);
				if(res.success) {
					accountgrid.getStore().load();
					clearForm();
				}else {
					showErrorDialog(res.errorMsg);
				}
		},
		failure : function(form,action) {
			showErrorDialog('增加帐号失败,请重试!');
		}
	});
}

function modifyAccount(){
	var store = accountgrid.getStore();
	var records =accountgrid.getSelectionModel().getSelection();
	if(Ext.isEmpty(records) || records.length == 0){
		Ext.Msg.show({
			title : '友情提示',
			msg : '请选择要一条要修改的记录!',
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.WARNING
		});
		return ;
	}
	var accountForm = Ext.getCmp("accountForm").getForm();
	if( !accountForm.isValid())  return ;
	Ext.MessageBox.buttonText.yes = "确 定";
	Ext.MessageBox.buttonText.no = "取 消";
	Ext.Msg.confirm('确认修改','你确定修改该条记录?',function(btn){
		if(btn == 'yes'){
			Ext.Ajax.request({
				url : 'sys/accounts_modify.action',
				params:{
					account : accountForm.findField("account").getValue(),
					name : accountForm.findField("name").getValue(),
					sex : accountForm.findField("sex").getValue(),
					roleid : accountForm.findField("roleid").getValue(),
					position : accountForm.findField("position").getValue(),
					note : accountForm.findField("note").getValue()
				},
				success : function(response,options){
					var res = Ext.decode(response.responseText);
					if(res.success){
						accountgrid.getStore().load();
					}else{
						showErrorDialog(res.errorMsg);
					}
				},
				failure : function() {
					showErrorDialog('修改帐号失败,请重试!');
				}
			});
		}
	});
}

function deleteAccount(){
	var records =accountgrid.getSelectionModel().getSelection();
	if(Ext.isEmpty(records) || records.length == 0) {
		Ext.Msg.show({
			title : '友情提示',
			msg : '请选择要删除的记录!',
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.WARNING
		});
		return ;
	}
	var accountForm = Ext.getCmp("accountForm").getForm();
	Ext.MessageBox.buttonText.yes = "确 定";
	Ext.MessageBox.buttonText.no = "取 消";
	Ext.Msg.confirm('确认删除', '你确定删除选中的记录?', function(btn) {
		if (btn == 'yes') {
			Ext.Ajax.request({
				url : 'sys/accounts_delete.action',
				params : {
					account : records[0].data.account
				},
				success : function(response, options) {
					accountgrid.getStore().load();
					clearForm();
				},
				failure : function() {
					showErrorDialog('删除帐号失败,请重试!');
				}
			});
		}
	});
}

function clearForm() {
	var accountForm = Ext.getCmp("accountForm").getForm();
	var accountField = accountForm.findField("account");
	accountField.setValue("");
	accountField.setDisabled(false);
	accountForm.findField("name").setValue("");
	accountForm.findField("sex").setValue("");	
	accountForm.findField("roleid").setValue("");
	accountForm.findField("position").setValue("");
	accountForm.findField("note").setValue("");
};
