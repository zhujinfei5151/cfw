/**
 * 操作掩码
 */
Ext.define('cfw.sys.store.MaskStore', {
	extend : 'Ext.data.ArrayStore',
	model : 'cfw.common.model.DisplayValuePair',
	data : [ [ '禁用', '0' ], [ '读', '1' ], [ '写', '2' ], [ '控制', '3' ] ]
});