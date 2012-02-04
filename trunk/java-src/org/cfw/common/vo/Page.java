package org.cfw.common.vo;

import java.util.List;

public class Page {

    private int     totalProperty; // 总记录数

    private List<?> root;         // 分页结果

    private int     startRow;     // 起始行

    private int     endRow;       // 结束行

    private Object  params;       // 查询条件

    public Page() {
    }

    public Page(int start, int limit) {
        this.startRow = start;
        this.endRow = start + limit;
    }

    public int getTotalProperty() {
        return totalProperty;
    }

    public void setTotalProperty(int totalProperty) {
        this.totalProperty = totalProperty;
    }

    @SuppressWarnings("rawtypes")
    public List getRoot() {
        return root;
    }

    @SuppressWarnings("rawtypes")
    public void setRoot(List root) {
        this.root = root;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

}
