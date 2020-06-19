package com.tea.pj.common.bo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 12312312312312L;
    private List<T> records;
    private Integer rowCount;
    private Integer pageCount;
    private Integer pageSize;
    private Integer pageCurrent;

    public PageObject(){}

    public PageObject(List<T> records, Integer rowCount, Integer pageSize, Integer pageCurrent) {
        this.records = records;
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageCount = (rowCount-1)/pageSize+1;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    @Override
    public String toString() {
        return "PageObject{" +
                "records=" + records +
                ", rowCount=" + rowCount +
                ", pageSize=" + pageSize +
                ", pageCurrent=" + pageCurrent +
                '}';
    }
}
