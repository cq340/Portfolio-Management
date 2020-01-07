package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Currencies {
    private Integer currenciesId;

    private String currenciesName;

    private Date currenciesDate;

    private Double price;

    private Double openPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double chg;

    public Integer getCurrenciesId() {
        return currenciesId;
    }

    public void setCurrenciesId(Integer currenciesId) {
        this.currenciesId = currenciesId;
    }

    public String getCurrenciesName() {
        return currenciesName;
    }

    public void setCurrenciesName(String currenciesName) {
        this.currenciesName = currenciesName == null ? null : currenciesName.trim();
    }

    public Date getCurrenciesDate() {
        return currenciesDate;
    }

    public void setCurrenciesDate(Date currenciesDate) {
        this.currenciesDate = currenciesDate;
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

    public Double getChg() {
        return chg;
    }

    public void setChg(Double chg) {
        this.chg = chg;
    }
}