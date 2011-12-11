Ext.define('cfw.sys.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	model:'cfw.model.Menu',
	root: {
	    text: '菜单树',
	    id: 'root',
	    expanded: true
	},
	proxy: {
	    type: 'ajax',
	    url: 'sys/role_menu.action',
	    reader : {
	    	type : 'json',
	    	idProperty : 'moduleid'
	    },
	    autoLoad : false
	},
	indexOf : function(record){
		return this.tree.root.lastChild.store.indexOf(record);
	}
});