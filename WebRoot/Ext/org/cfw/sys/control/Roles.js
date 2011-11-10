var modulegrid;
var menustore;
Ext.onReady(function() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	var vp = new cfw.sys.view.ui.RolesViewport({
		renderTo : Ext.getBody()
	});
	vp.show();
	
	init();
});

function init() {
	var rolegrid = Ext.getCmp('rolegrid');
	var rolestore = rolegrid.getStore();
	rolestore.load();
	
	modulegrid = Ext.getCmp('modulegrid');
	menustore = modulegrid.getStore();
	menustore.load();
	
	var plugin = modulegrid.getPlugin();
	plugin.on('edit',onEdit)
}

function onEdit(editor,e,options) {
	var index = e.rowIdx;
	var value = e.value;
	var field = e.field;
	var record = e.record.data;
	var match = "00000000";
	var match2 = "00000000";
	var moduleid = record.moduleid;
	//随动设置值 对子孙模块和兄弟模块(三级)
	if(moduleid.indexOf('000000')> 0) {
		match = moduleid.substring(0,2);
		match2 = moduleid.substring(0,2);
	} else if(moduleid.indexOf('0000')> 0) {
		match = moduleid.substring(0,4);
		match2 = moduleid.substring(0,4);
	} else if(moduleid.indexOf('00')> 0) {
		match = moduleid.substring(0,4);
		match2 = moduleid.substring(0,6);
	}
	for ( var i = index; i < menustore.data.length; i++) {
		moduleid = menustore.data.items[i].data.moduleid;
		var mask = menustore.data.items[i].data.mask;
		if(moduleid.indexOf(match) == 0) {
			menustore.data.items[i].data.mask = value;
		}
	}
	
	//父对象取子孙对象的最小级别，"禁用"例外，除非所有子孙对象都一致
	while(match2.length > 2) {
		match2 = match2.substring(0,match2.length - 2);
		var minMask = getMinFromBrotherSon(match2,value);
		
		match = rightPad(match2,8,"0");
		for ( var i = 0; i < index; i++) {
			moduleid = menustore.data.items[i].data.moduleid;
			if(moduleid == match) {
				menustore.data.items[i].data.mask = minMask;
				break;
			}
		}
	}
	modulegrid.getView().refresh();
}

/**
 * 取兄弟和子孙的操作码中最小级别的操作码(>=可读)
 * @param match
 * @returns {Boolean}
 */
function getMinFromBrotherSon(match,value) {
	var isSame = true;
	var minMask = "3";//默认可控制
	for ( var i = 0; i < menustore.data.length; i++) {
		var moduleid = menustore.data.items[i].data.moduleid;
		var mask = menustore.data.items[i].data.mask;
		if(moduleid.indexOf(match) == 0) {
			//操作码(>=可读)
			if(parseInt(mask) > 0 && parseInt(mask) < parseInt(minMask)) {
				minMask = mask;
			}
			//是否为同一值
			if(moduleid != rightPad(match,8,"0") && value != mask) {
				isSame = false;
			} 
		}
	}
	if(isSame) {
		return value;
	} else {
		return minMask;
	}
}
