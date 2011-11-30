package org.cfw.common;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.cfw.biz.sys.dao.SysModuledefMapper;
import org.cfw.biz.sys.model.SysModuledef;
import org.cfw.biz.sys.model.SysModuledefExample;
import org.cfw.common.util.PropertiesUtil;

public class CachedVOUtil {

    static SysModuledefMapper          sysModuledefMapper;
    private static final String        SYS_MODULEDEF = "SysModuledef";               // 系统功能菜单
    private static final String        SYS_PARAMS    = "SysParams";                  // 系统全局参数

    private static Map<String, Object> cache         = new HashMap<String, Object>();

    @SuppressWarnings("unchecked")
    public static List<SysModuledef> getModuledefList() {
        List<SysModuledef> list = (List<SysModuledef>) cache.get(SYS_MODULEDEF);
        if (list == null) {
            SysModuledefExample example = new SysModuledefExample();
            example.setOrderByClause("ModuleID");
            list = sysModuledefMapper.selectByExample(example);
            cache.put("SysModuledef", list);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static String getSysParam(String name) throws IOException {
        Map<String, String> paramMap = (Map<String, String>) cache.get(SYS_PARAMS);
        if (paramMap == null) {
            paramMap = new HashMap<String, String>();
            Properties p = new Properties();
            URL url = PropertiesUtil.class.getClassLoader().getResource("");
            name = url.toString().substring(6, (url.toString().indexOf("classes")));
            name += "conf/sysparams.properties";
            p = PropertiesUtil.loadProperties(name, PropertiesUtil.BY_PROPERTYRESOURCEBUNDLE);
            Enumeration<?> keys = p.propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                paramMap.put(key, p.getProperty(key));
            }
            cache.put(SYS_PARAMS, paramMap);
        }

        return (String) paramMap.get(name);
    }

    public void setSysModuledefMapper(SysModuledefMapper sysModuledefMapper) {
        CachedVOUtil.sysModuledefMapper = sysModuledefMapper;
    }
}
