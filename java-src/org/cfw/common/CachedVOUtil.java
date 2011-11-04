package org.cfw.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cfw.biz.sys.dao.SysModuledefMapper;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysModuledefExample;

public class CachedVOUtil {

    static SysModuledefMapper          sysModuledefMapper;

    private static Map<String, Object> cache = new HashMap<String, Object>();

    @SuppressWarnings("unchecked")
    public static List<SysModuledef> getModuledefList() {
        List<SysModuledef> list = (List<SysModuledef>) cache.get("SysModuledef");
        if (list == null) {
            SysModuledefExample example = new SysModuledefExample();
            example.setOrderByClause("ModuleID");
            list = sysModuledefMapper.selectByExample(example);
            cache.put("SysModuledef", list);
        }
        return list;
    }

    public void setSysModuledefMapper(SysModuledefMapper sysModuledefMapper) {
        CachedVOUtil.sysModuledefMapper = sysModuledefMapper;
    }
}
