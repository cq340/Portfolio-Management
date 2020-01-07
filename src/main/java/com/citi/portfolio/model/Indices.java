package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Indices {
    private Integer indiciesId;

    private String indiciesName;

    private Date indicesDate;

    private Double price;

    private Double openPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double vol;

    private Double chg;

    private String changeRate;

    private Boolean x;

    public Boolean getX() {
        return x;
    }

    public void setX(Boolean x) {
        this.x = x;
    }

    public String getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(String changeRate) {
        this.changeRate = changeRate;
    }

    public Integer getIndiciesId() {
        return indiciesId;
    }

    public void setIndiciesId(Integer indiciesId) {
        this.indiciesId = indiciesId;
    }

    public String getIndiciesName() {
        return indiciesName;
    }

    public void setIndiciesName(String indiciesName) {
        this.indiciesName = indiciesName == null ? null : indiciesName.trim();
    }

    public Date getIndicesDate() {
        return indicesDate;
    }

    public void setIndicesDate(Date indicesDate) {
        this.indicesDate = indicesDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Double getChg() {
        return chg;
    }

    public void setChg(Double chg) {
        this.chg = chg;
    }
}