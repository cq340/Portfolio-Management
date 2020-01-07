package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class PortfolioDashboard {
    private Integer userId;

    private String userName;

    private Integer portId;

    private String portName;

    private Date positionDate;

    private Integer qty;

    private String itemName;

    private Double cash;

    private Double stockPrice;

    private Double commodityPrice;

    private Double iniPrice;

    private Double portValue;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
    }

    public Date getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(Date positionDate) {
        this.positionDate = positionDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Double getIniPrice() {
        return iniPrice;
    }

    public void setIniPrice(Double iniPrice) {
        this.iniPrice = iniPrice;
    }

    public Double getPortValue() {
        return portValue;
    }

    public void setPortValue(Double portValue) {
        this.portValue = portValue;
    }
}