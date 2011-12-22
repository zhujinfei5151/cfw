var modulegrid;
var menustore;
var moduleform;
var rolegrid;
var rolestore;
var records = [];
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
	modulegrid = Ext.getCmp('modulegrid');
	
	
	moduleform = Ext.getCmp('moduleform');
	rolegrid = Ext.getCmp('rolegrid');
	rolegrid.on('selectionchange',roleSelectionChange);
	
	rolemodel = Ext.ModelMgr.getModel('cfw.sys.model.Role');
	moduleform.loadRecord(rolemodel);
	
	menustore = modulegrid.getStore();
	rolestore = rolegrid.getStore();
	rolestore.load();
	
	var addButton = moduleform.down('button[action=add]');
	var modifyButton = moduleform.down('button[action=modify]');
	var removeButton = moduleform.down('button[action=remove]');
	addButton.on('click',addRole);
	modifyButton.on('click',modifyRole);
	removeButton.on('click',removeRole);
	
	menustore.on('load',loadmenustore);
	
	var plugin = modulegrid.getPlugin();
	plugin.on('edit',onEdit);
	initRole();
}

function loadmenustore(store,node,recordst,success,options){
	if(success && recordst.length > 0){
		Ext.Array.forEach(recordst,function(itemnode){
			if(!itemnode.data.leaf){
				getMaxFromChildren(itemnode);
			}
		});
	}
}

function roleSelectionChange(model,selected,options){
	if(selected.length == 0){
		initRole();
		return;
	}
//	if(selected.length != 1) return;
	moduleform.loadRecord(selected[selected.length - 1]);
	roleModuleList = selected[0].data.roleModuleList;
	if(records.length == 0){
		records = nodeRecords(menustore.getRootNode());
	} 
	var flag = false;
	Ext.Array.forEach(records,function(record){
		var moduleid = record.data.moduleid;
		flag = false;
		Ext.Array.each(roleModuleList,function(roleModule){
			if(moduleid == roleModule.moduleid){
				flag = true;
				record.data.mask = roleModule.mask;
				return false;
			}
		});
		if(!flag){
			record.data.mask = 0;
		}
	});
	modulegrid.getView().refresh();
}

function onEdit(editor,e,options) {
	var value = e.value;	
	var node = modulegrid.getSelectionModel().selected.items[0];
	var children = [];
	var children2 = node.childNodes;
	var children3 = [];
	while(children2.length != 0){
		Ext.Array.forEach(children2,function(item){
			if(value <= item.data.maxmask){
				item.data.mask = value;
			}
			if(!item.data.leaf){
				Ext.Array.forEach(item.childNodes,function(itemchild){
					children3.push(itemchild);
				});
			}
			children.push(item);
		});
		children2 = [];
		Ext.Array.forEach(children3,function(item){
			children2.push(item);
		})
		children3 = [];
  };
  if(node.data.root){
	  modulegrid.getView().refresh();
	  return;
  }
  if(node.data.leaf){
	  followerAfterBrother(node);
  }
  var minMask = getMinFromBrother(node);
  var parentNode = node.parentNode;
  while(parentNode.parentNode != null){
	  parentNode.data.mask = minMask;
	  parentNode = parentNode.parentNode;
  }
  modulegrid.getView().refresh();
}
/**
 * 随动设置子节点的兄弟操作码值
 */
function followerAfterBrother(node){
	var brotherNodes = node.parentNode.childNodes;
	var index = Ext.Array.indexOf(brotherNodes,node,0);
	var mask = node.data.mask;
	Ext.Array.each(brotherNodes,function(itemNode,indexNode){
		if(indexNode > index && mask <= itemNode.data.maxmask){
			itemNode.data.mask = mask;
		}
	})
}
/**
 * 取兄弟操作码中最小级别的操作码(>=可读)
 * @param match
 * @returns {Boolean}
 */
function getMinFromBrother(node){
	var isSame = true;
	var minMask = 3;//默认可控制
	var nodeMask = node.data.mask;
	var brotherNodes = node.parentNode.childNodes;
	Ext.Array.each(brotherNodes,function(itemNode){
		var mask = itemNode.data.mask;
		if(node !== itemNode && node.data.mask != mask){
			isSame = false;
		}
		if(mask > 0 && mask < minMask){
			minMask = mask;
		}
	})
	if(isSame){
		return nodeMask;
	}else{
		return minMask;
	}
}

/**
 * 取子节点操作码中最大级别的操作码
 */
function getMaxFromChildren(node){
	var children = node.childNodes;
	var maxMask = 0;
	var mask;
	Ext.Array.forEach(children,function(itemNode){
		if(itemNode.data.leaf){
			mask = itemNode.data.maxmask;
		}else{
			mask = getMaxFromChildren(itemNode);
		}
		if(mask > maxMask){
			maxMask = mask;
		}
	});
	node.data.maxmask = maxMask;
	return maxMask;
}

function addRole(){
	var form = moduleform.getForm();
	var data = [];
	var data1 = [];
	var rd;
	if(records.length == 0){
		records = nodeRecords(menustore.getRootNode());
	} 
	Ext.Array.forEach(records,function(record){
		rd = new Object();
		rd.moduleid = record.data.moduleid;
		rd.mask = record.data.mask;
		data1.push(rd);
		data.push(Ext.JSON.encode(rd));
	});
	Ext.Ajax.request({
		url : 'sys/role_addRole.action',
		params : {
			name : form.findField('name').getValue(),
			rolecomment : form.findField('rolecomment').getValue(),
			data : '[' + data.join(',') + ']'
		},
		method : 'post',
		success : function(response,options){
			var roleModel = Ext.ModelMgr.create({
				roleid : Ext.decode(response.responseText).roleid,
				name : form.findField('name').getValue(),
				rolecomment : form.findField('rolecomment').getValue(),
				roleModuleList : data1
			},'cfw.sys.model.Role');
			rolestore.add(roleModel);
			rolegrid.getSelectionModel().select(roleModel);
			Ext.Msg.alert('提示','增添新角色成功!');
		},
		failure : function(response,options){
			Ext.Msg.alert('提示','增添新角色失败!');
		}
	});
}

//获取一节点下所有的子节点
function nodeRecords(node){
	var recordst = [];
	var children = node.childNodes;
	if(children.length != 0){
		Ext.Array.forEach(children,function(childNode){
			recordst.push(childNode);
			if(!childNode.data.leaf){
				Ext.Array.forEach(nodeRecords(childNode),function(itemNode){
					recordst.push(itemNode);
				});
			}
		})
	}
	return recordst;
}

function modifyRole(){
	var form = moduleform.getForm();
	var record = moduleform.getRecord();
	var data = [];
	var data1 = [];
	var rd;
	if(records.length == 0){
		records = nodeRecords(menustore.getRootNode());
	} 
	Ext.Array.forEach(records,function(record){
		rd = new Object();
		rd.moduleid = record.data.moduleid;
		rd.mask = record.data.mask;
		data1.push(rd);
		data.push(Ext.JSON.encode(rd));
	});
	
	Ext.Ajax.request({
		url : 'sys/role_modifyRole.action',
		params : {
			roleid : record.data.roleid,
			name : form.findField('name').getValue(),
			rolecomment : form.findField('rolecomment').getValue(),
			data : '[' + data.join(',') + ']'
		},
		method : 'post',
		success : function(response,options){
			record.set('name',form.findField('name').getValue());
			record.set('rolecomment',form.findField('rolecomment').getValue());
			record.set('roleModuleList',data1);
			record.commit();
			Ext.Array.forEach(records,function(record){
				if(record.dirty){
					record.commit();
				}
			});
			Ext.Msg.alert('提示','修改角色信息成功!');
		},
		failure : function(response,options){
			Ext.Msg.alert('提示','修改角色信息失败!');
		}
	});
}

function removeRole(){
	var record = moduleform.getRecord();
	rolestore.remove(record);
	Ext.Ajax.request({
		url : 'sys/role_removeRole.action',
		params : {
			roleid : record.data.roleid
		},
		method : 'post',
		success : function(response,options){
			rolestore.remove(record);
			initRole();
			Ext.Msg.alert('提示','删除角色成功!');
		},
		failure : function(response,options){
			Ext.Msg.alert('提示','删除角色失败');
		}
	});
}

function initRole(){
	var record = Ext.ModelMgr.create({},'cfw.sys.model.Role');
	moduleform.loadRecord(record);
	if(records.length == 0){
		records = nodeRecords(menustore.getRootNode());
	} 
	Ext.Array.forEach(records,function(record){
		record.data.mask = 0;
	});
	modulegrid.getView().refresh();
}

