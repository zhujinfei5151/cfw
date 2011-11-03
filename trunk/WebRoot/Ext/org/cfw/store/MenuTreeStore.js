Ext.define('cfw.store.FuncTreeStore', {
    extend: 'Ext.data.TreeStore',
    model:'cfw.model.TreeNode',
	root: {
        text: '菜单树',
        id: 'root',
        expanded: true
    },
    proxy: {
        type: 'ajax',
        url : 'data/ModuleNodes.json',
        reader: {
            type: 'json',
            root: 'nodes',
            successProperty: 'success'
        }
    }
});