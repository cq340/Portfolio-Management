package com.citi.portfolio.model;

import com.citi.portfolio.util.NumberFormatter;
import org.springframework.stereotype.Component;

@Component
public class ManagerPerformance {
    private Double initValue;
    private Double currentValue;
    private SystemUser manager;
    private Double amount;
    private String percent;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInitValue() {
        return new NumberFormatter().format(initValue);
    }

    public void setInitValue(Double initValue) {
        this.initValue = initValue;
    }

    public Double getCurrentValue() {
        return new NumberFormatter().format(currentValue);
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public SystemUser getManager() {
        return manager;
    }

    public void setManager(SystemUser manager) {
        manager.setPassword("");
        this.manager = manager;
    }


    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
