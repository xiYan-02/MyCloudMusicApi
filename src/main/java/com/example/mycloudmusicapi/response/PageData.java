package com.example.mycloudmusicapi.response;

public class PageData {

    public PageData(Object data) {
        this.data = data;
    }

    public PageData() {
    }

    public static Object init(Object data){
        return new PageData(data);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 总分页数
     */
    private Integer totalPages;


    /**
     * 总数量
     */
    private Integer totalCount;

    /**
     * 真实数据
     */
    private Object data;



}
