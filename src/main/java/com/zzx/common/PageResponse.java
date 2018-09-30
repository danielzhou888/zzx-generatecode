package com.zzx.common;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class PageResponse extends ServiceResponse {
    private static final long serialVersionUID = 1L;

    private Integer size;
    private Integer pages;
    private Integer current;
    private Integer total;
    private String version;

    public PageResponse() {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public  void assignPage(Page page) {
        if (page != null) {
            this.size = page.getSize();
            this.pages = page.getPages();
            this.current = page.getCurrent();
            this.total = page.getTotal();
            this.setData(page.getRecords());
            //this.data=page.getRecords();
        }
    }

    public static PageResponse createResponse(Integer total, Object data, PageRequest request) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setTotal(total);
        pageResponse.setCurrent(request.getCurrent());
        pageResponse.setData(data);
        if (request.getSize() != null) {
            pageResponse.setSize(request.getSize());
            pageResponse.setPages(total / request.getSize() == 0 ? total / request.getSize() : total / request.getSize() + 1);
            if (pageResponse.getPages() == 0) {
                pageResponse.setPages(1);
            }
        }
        return pageResponse;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
