package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.model.Commodities;

import java.util.Date;
import java.util.List;

public interface CommoditiesService {
    Double getPriceByDate(String name, Date date);
    List<Double> getPriceTrend(String name, Date startDate, Date endDate);
    List<Commodities> getByName(String name);
}
