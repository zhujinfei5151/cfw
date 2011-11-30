package org.cfw.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cfw.biz.sys.model.SysAccount;
import org.cfw.biz.sys.model.SysAccountExample;

public interface SysAccountMapper {

    int countByExample(SysAccountExample example);

    int deleteByExample(SysAccountExample example);

    int deleteByPrimaryKey(String account);

    int insert(SysAccount record);

    int insertSelective(SysAccount record);

    List<SysAccount> selectByExample(SysAccountExample example);

    SysAccount selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByExample(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    int updateByPrimaryKeySelective(SysAccount record);

    int updateByPrimaryKey(SysAccount record);
}
