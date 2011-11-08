Ext.define('cfw.sys.store.MenuStore', {
    extend: 'Ext.data.Store',
    model:'cfw.model.Menu',
    proxy: {
        type: 'ajax',
        url : 'sys/role_menu.action',
        reader: 'json'
    }
});