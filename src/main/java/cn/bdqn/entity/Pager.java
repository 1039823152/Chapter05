package cn.bdqn.entity;

import java.util.List;

public class Pager<T> {
    private int pageNo;
    private int pageSize;
    private int totalRows;
    private int totalPage;
    private List<Hosts> datas;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Hosts> getDatas() {
        return datas;
    }

    public void setDatas(List<Hosts> datas) {
        this.datas = datas;
    }
}
