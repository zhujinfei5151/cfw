WELCOME_URL='Ext/welcome.jsp';//欢迎页面

/**
 * 用于grid渲染列值
 * @param store 
 * @param value
 * @returns
 */
function renderByValue(store,value){
	if (!store){
		return value;
	}
	for ( var i = 0; i < store.data.length; i++) {
		if (store.data.items[i].data.value == value) {
			return store.data.items[i].data.display;
		}
	}
	return value;
}

/**
 * 字符串右补自定字符，直到指定长度
 */
function rightPad(string, size, character) {
    var result = String(string);
    character = character || " ";
    while (result.length < size) {
        result += character;
    }
    return result;
}

/**
 * 显示错误提示的对话框
 */
function showErrorDialog(msg) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.ERROR
	});
}

/**
 * 显示警告对话框
 */
function showWarningDialog(msg) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.WARNING
	});
}

/**
 * 显示提示信息的对话框
 */
function showInfoDialog(msg) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.INFO
	});
}