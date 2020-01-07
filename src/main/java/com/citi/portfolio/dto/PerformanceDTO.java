package com.citi.portfolio.dto;

import com.citi.portfolio.model.ManagerPerformance;

import java.util.List;

public class PerformanceDTO {
    private List<ManagerPerformance> managerPerformances;
    private Long size;

    public List<ManagerPerformance> getManagerPerformances() {
        return managerPerformances;
    }

    public void setManagerPerformances(List<ManagerPerformance> managerPerformances) {
        this.managerPerformances = managerPerformances;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
