Ext.define('cfw.sys.store.AccountFormRoleStore', {
    extend: 'Ext.data.Store',
    model:'cfw.sys.model.Role',
    proxy: {
        type: 'ajax',
        url : 'sys/role_queryAllRole.action',
        reader: 'json'
    }
});