package com.zzx.common;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer total;
    private Integer size = 20;
    private Integer pages;
    private Integer current = 1;
    private String searchCount;
    private String openSort;
    private String orderBy;
    private String ordering;

    private Integer startNum = 0;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(String searchCount) {
        this.searchCount = searchCount;
    }

    public String getOpenSort() {
        return openSort;
    }

    public void setOpenSort(String openSort) {
        this.openSort = openSort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public boolean descOrdering() {
        return "desc".equals(this.ordering);
    }

    public Integer getStartNum() {
        return (this.current - 1) * size;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public static Page toPage(PageRequest request) {
        Page page = new Page();
        page.setAsc(request.descOrdering());
        page.setCurrent(request.getCurrent());
        //page.setOpenSort();
        page.setSize(request.getSize());
        page.setOrderByField(request.getOrderBy());
        //page.setSearchCount();
        page.setTotal(request.getTotal());
        return page;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
