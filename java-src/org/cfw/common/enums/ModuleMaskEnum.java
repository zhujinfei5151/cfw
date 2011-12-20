package org.cfw.common.enums;

import org.apache.commons.lang.StringUtils;

public enum ModuleMaskEnum {
    DISABLE("0", "禁用"), READ("1", "读"), WRITE("2", "写"), CONTROL("3", "控制");

    private final String value;
    private final String name;

    ModuleMaskEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public short getShortValue() {
        return Short.valueOf(value);
    }

    public String getName() {
        return name;
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static ModuleMaskEnum getEnmuByValue(String value) {
        for (ModuleMaskEnum commType : ModuleMaskEnum.values()) {
            if (StringUtils.equals(value, commType.getValue())) {
                return commType;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static ModuleMaskEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (ModuleMaskEnum commType : ModuleMaskEnum.values()) {
            if (StringUtils.equals(name, commType.toString())) {
                return commType;
            }
        }
        return null;
    }
}
