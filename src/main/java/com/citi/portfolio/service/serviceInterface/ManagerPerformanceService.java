package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.dto.PerformanceDTO;
import com.citi.portfolio.model.ManagerPerformance;
import com.citi.portfolio.model.SystemUser;

import java.util.List;

public interface ManagerPerformanceService {
    ManagerPerformance getPerformance(Integer mID);
    Double getManagerInitValue(SystemUser manager);
    Double getCurrentValue(SystemUser manager);
    PerformanceDTO getPerformance(Integer from, Integer size, String... args);
}
