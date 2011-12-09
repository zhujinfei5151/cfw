Ext.define('cfw.model.Menu', {
	extend : 'Ext.data.Model',
	fields : [ 'text', 'menus', 'iconCls', 'url', 'handler', 'moduleid', {
		name : 'maxmask',
		mapping : 'mask'
	} ]
});