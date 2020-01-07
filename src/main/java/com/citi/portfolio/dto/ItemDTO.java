package com.citi.portfolio.dto;

import java.util.List;

public class ItemDTO{
    List<Object> list;
    Long size;
    private Double curCash;

    public Double getCurCash() {
        return curCash;
    }

    public void setCurCash(Double curCash) {
        this.curCash = curCash;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
