package org.cfw.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysRoleModule;
import org.cfw.biz.sys.model.SysRoleModuleExample;
import org.cfw.biz.sys.model.SysRoleModuleKey;

public interface SysRoleModuleMapper {

    int countByExample(SysRoleModuleExample example);

    int deleteByExample(SysRoleModuleExample example);

    int deleteByPrimaryKey(SysRoleModuleKey key);

    int insert(SysRoleModule record);

    int insertSelective(SysRoleModule record);

    List<SysRoleModule> selectByExample(SysRoleModuleExample example);

    SysRoleModule selectByPrimaryKey(SysRoleModuleKey key);

    int updateByExampleSelective(@Param("record") SysRoleModule record, @Param("example") SysRoleModuleExample example);

    int updateByExample(@Param("record") SysRoleModule record, @Param("example") SysRoleModuleExample example);

    int updateByPrimaryKeySelective(SysRoleModule record);

    int updateByPrimaryKey(SysRoleModule record);

    List<SysModuledef> selectModuledefByRoleID(Short roleid);
}
