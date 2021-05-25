package org.entity;

public class StudentRequest {
    private int pageNow; //当前页
    private int pageSize;//每页的条目数
    private String searchKey; //查询关键词
    private int startPage; //起始页

    public int getStartPage() {
        return (pageNow - 1) * pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
