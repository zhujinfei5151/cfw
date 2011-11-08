Ext.define('cfw.sys.store.RoleStore', {
    extend: 'Ext.data.Store',
    model:'cfw.sys.model.Role',
    proxy: {
        type: 'ajax',
        url : 'sys/role_query.action',
        reader: 'json'
    }
});