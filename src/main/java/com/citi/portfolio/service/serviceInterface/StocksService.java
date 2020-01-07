package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.model.Stocks;

import java.util.Date;
import java.util.List;

public interface StocksService {
    Double getPriceByDate(String name, Date date);
    List<Double> getPriceTrend(String name,Date startDate,Date endDate);
    List<Stocks> getByName(String name);
}
