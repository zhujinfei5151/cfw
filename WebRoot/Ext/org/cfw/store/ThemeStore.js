/**
 * 主题样式
 */
Ext.define('org.cfw.store.ThemeStore', {
	extend : 'Ext.data.ArrayStore',
	model : 'cfw.common.model.DisplayValuePair',
	data : [ [ '蓝色', 'index.action' ], [ '灰色', 'index_gray.action' ], [ '黑白', 'index_access.action' ]]
});