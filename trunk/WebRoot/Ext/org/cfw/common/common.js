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

function logout() {
	showErrorDialog('您的会话已结束,请重新登录!',function() {
		top.location = 'logout.action';
	});
}

function accessDenied() {
	showErrorDialog('很抱歉,您无权访问该功能!');
}

//显示提示信息的对话框
function showInfoDialog(msg,fn) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		fn : fn,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.INFO
	});
}

//显示错误提示的对话框
function showErrorDialog(msg,fn) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		fn : fn,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.ERROR
	});
}

// 显示警告对话框
function showWarningDialog(msg,fn) {
	Ext.Msg.show( {
		title :"提示",
		msg :msg,
		fn : fn,
		buttons :Ext.Msg.OK,
		icon :Ext.Msg.WARNING
	});
}