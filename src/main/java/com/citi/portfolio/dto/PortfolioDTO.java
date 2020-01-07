package com.citi.portfolio.dto;

import com.citi.portfolio.model.Portfolio;

import java.util.List;

public class PortfolioDTO {
    private List<Portfolio> portfolios;
    private Long size;

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
