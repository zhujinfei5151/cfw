Ext.define('cfw.store.TabStore', {
    extend: 'Ext.data.Store',
    model:'cfw.model.Menu',
    proxy: {
        type: 'ajax',
        url : 'tabstore.action',
        reader: 'json'
    }
});