Ext.define('cfw.store.MenuStore', {
    extend: 'Ext.data.Store',
    model:'cfw.model.Menu',
    proxy: {
        type: 'ajax',
        url : 'menu.action',
        reader: 'json'
    }
});