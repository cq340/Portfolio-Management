package com.citi.portfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Commodities {
    @JsonProperty("id")
    private Integer commoditiesId;

    @JsonProperty("name")
    private String commoditiesName;

    @JsonProperty("date")
    private Date commDate;

    private Double price;

    private Double openPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double vol;

    private Double chg;

    public Integer getCommoditiesId() {
        return commoditiesId;
    }

    public void setCommoditiesId(Integer commoditiesId) {
        this.commoditiesId = commoditiesId;
    }

    public String getCommoditiesName() {
        return commoditiesName;
    }

    public void setCommoditiesName(String commoditiesName) {
        this.commoditiesName = commoditiesName == null ? null : commoditiesName.trim();
    }

    public Date getCommDate() {
        return commDate;
    }

    public void setCommDate(Date commDate) {
        this.commDate = commDate;
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