var modulegrid;
var menustore;
Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.sys.view.ui.RolesViewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	
	init();
});

function init() {
	var rolegrid = Ext.getCmp('rolegrid');
	var rolestore = rolegrid.getStore();
	rolestore.load();
	
	modulegrid = Ext.getCmp('modulegrid');
	menustore = modulegrid.getStore();
	menustore.load();
	
	var plugin = modulegrid.getPlugin();
	plugin.on('edit',onEdit)
}

function onEdit(editor,e,options) {
	var index = e.rowIdx;
	var value = e.value;
	var field = e.field;
	var record = e.record.data;
	var match = "00000000";
	var moduleid = record.moduleid;
	//随动处理仅对子孙模块有效
	if(moduleid.indexOf('000000')> 0) {
		match = moduleid.substring(0,2);
	} else if(moduleid.indexOf('0000')> 0) {
		match = moduleid.substring(0,4);
	} else if(moduleid.indexOf('00')> 0) {
		match = moduleid.substring(0,4);
	} 
	for ( var i = index; i < menustore.data.length; i++) {
		if(field == 'mask') {
			
			moduleid = menustore.data.items[i].data.moduleid;
			if(moduleid.indexOf(match) == 0) {
				menustore.data.items[i].data.mask = value;
			}
		}
	}
	modulegrid.getView().refresh();
}
