package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.dto.PortfolioDTO;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioExample;
import com.citi.portfolio.model.Position;

import java.util.List;

public interface PortfolioService {
    Double calValue(Portfolio portfolio);
    Double getInitValue(Portfolio portfolio);
    Boolean calCash(Position position);
    void add(Portfolio portfolio);
    void updateCash(Portfolio portfolio, Double cash);
    void changeManager(Integer formerID, Integer curId, Integer portId);
    PortfolioDTO getAll();
    PortfolioDTO getByExample(PortfolioExample portfolioExample);
    PortfolioDTO getByManager(Integer mID, Integer from, Integer size, String... args);
    Portfolio getById(Integer portId);
}
