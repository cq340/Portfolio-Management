package com.citi.portfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Stocks {
    @JsonProperty("id")
    private Integer stocksId;

    @JsonProperty("name")
    private String stocksName;

    @JsonProperty("date")
    private Date stocksDate;

    private Double price;

    private Double openPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double vol;

    private Double chg;

    public Integer getStocksId() {
        return stocksId;
    }

    public void setStocksId(Integer stocksId) {
        this.stocksId = stocksId;
    }

    public String getStocksName() {
        return stocksName;
    }

    public void setStocksName(String stocksName) {
        this.stocksName = stocksName == null ? null : stocksName.trim();
    }

    public Date getStocksDate() {
        return stocksDate;
    }

    public void setStocksDate(Date stocksDate) {
        this.stocksDate = stocksDate;
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