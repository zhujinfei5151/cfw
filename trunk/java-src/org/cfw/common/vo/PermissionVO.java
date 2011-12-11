package org.cfw.common.vo;

import java.util.List;

public class PermissionVO {

    private List<ModulePermitVO> moduleList; // 功能权限

    public List<ModulePermitVO> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ModulePermitVO> moduleList) {
        this.moduleList = moduleList;
    }
}
