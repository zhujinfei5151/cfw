Ext.define('cfw.store.ObjTreeStore', {
    extend: 'Ext.data.TreeStore',
    model:'cfw.model.TreeNode',
	root: {
        text: '菜单树',
        id: 'root',
        expanded: true
    },
    proxy: {
        type: 'ajax',
        url : 'data/DistributeNodes.json',
        reader: {
            type: 'json',
            root: 'nodes',
            successProperty: 'success'
        }
    }
});