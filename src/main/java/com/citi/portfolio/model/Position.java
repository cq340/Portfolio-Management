package com.citi.portfolio.model;

import com.citi.portfolio.util.NumberFormatter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Position {
    private Integer positionId;

    private Double iniPrice;

    private Integer portId;

    private String itemName;

    private Integer qty;

    private Date positionDate;

    private Double curPrice;

    private Double totalValue;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotalValue() {
        return new NumberFormatter().format(totalValue);
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Double getIniPrice() {
        return new NumberFormatter().format(iniPrice);
    }

    public void setIniPrice(Double iniPrice) {
        this.iniPrice = iniPrice;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(Date positionDate) {
        this.positionDate = positionDate;
    }

    public Double getCurPrice() {
        return new NumberFormatter().format(curPrice);
    }

    public void setCurPrice(Double curPrice) {
        this.curPrice = curPrice;
    }
}