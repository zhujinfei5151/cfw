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
}
