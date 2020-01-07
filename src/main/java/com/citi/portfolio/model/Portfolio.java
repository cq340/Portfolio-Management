package com.citi.portfolio.model;

import com.citi.portfolio.util.NumberFormatter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Portfolio {
    private Integer portId;

    private Date portDate;

    private Integer managerId;

    private String portName;

    private Double cash;

    private Double portValue;

    private Double currentValue;

    private Double amount;

    private String percent;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Double getCurrentValue() {
        return new NumberFormatter().format(currentValue);
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public Date getPortDate() {
        return portDate;
    }

    public void setPortDate(Date portDate) {
        this.portDate = portDate;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName == null ? null : portName.trim();
    }

    public Double getCash() {
        return new NumberFormatter().format(cash);
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getPortValue() {
        return new NumberFormatter().format(portValue);
    }

    public void setPortValue(Double portValue) {
        this.portValue = portValue;
    }
}