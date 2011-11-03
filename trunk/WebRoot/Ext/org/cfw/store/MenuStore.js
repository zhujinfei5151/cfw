Ext.define('cfw.store.MenuStore', {
    extend: 'Ext.data.Store',
    model:'cfw.model.Menu',
    proxy: {
        type: 'ajax',
        url : 'data/Menus.json',
        reader: 'json'
    }
});