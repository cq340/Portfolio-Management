package com.citi.portfolio.service.serviceInterface;

        import com.citi.portfolio.model.PortfolioDashboard;


        import java.util.List;
        import java.util.Map;

public interface PortfolioDashboardService {
    List<PortfolioDashboard> getByPortId(int portID);
    List<PortfolioDashboard> getByManagerId(int managerID);
    List<PortfolioDashboard> getByPortfolioName(String portfolioName);
    Map<String,Double> sort(String... args);
}
