package org.cfw.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysModuledefExample;

public interface SysModuledefMapper {

    int countByExample(SysModuledefExample example);

    int deleteByExample(SysModuledefExample example);

    int deleteByPrimaryKey(String moduleid);

    int insert(SysModuledef record);

    int insertSelective(SysModuledef record);

    List<SysModuledef> selectByExample(SysModuledefExample example);

    SysModuledef selectByPrimaryKey(String moduleid);

    int updateByExampleSelective(@Param("record") SysModuledef record, @Param("example") SysModuledefExample example);

    int updateByExample(@Param("record") SysModuledef record, @Param("example") SysModuledefExample example);

    int updateByPrimaryKeySelective(SysModuledef record);

    int updateByPrimaryKey(SysModuledef record);
}
