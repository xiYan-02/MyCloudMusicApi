package com.example.mycloudmusicapi.domain;

import lombok.Data;

import java.util.List;

/**
 * 分页包裹对象
 * @param <T>
 */
@Data
public class PageData<T> {
    public PageData(int currentPage, int totalPages, int totalCount, List<T> datas) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalCount = totalCount;
        this.datas = datas;
    }

    public PageData() {
    }

    /**
     * 当前页数
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 总数量
     */
    private int totalCount;

    /**
     * 数据
     */
    private List<T> datas;

}
