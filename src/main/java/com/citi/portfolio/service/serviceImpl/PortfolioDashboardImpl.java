package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.PortfolioDashboardMapper;
import com.citi.portfolio.dto.PortfolioDTO;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioDashboard;
import com.citi.portfolio.model.PortfolioDashboardExample;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.service.serviceInterface.PortfolioDashboardService;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.portfolio.service.serviceInterface.SystemUserService;
import com.citi.portfolio.util.ExampleFormatter;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PortfolioDashboardImpl implements PortfolioDashboardService{
    @Autowired
    PortfolioDashboardMapper portfolioDashboardMapper;
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public List<PortfolioDashboard> getByPortId(int portID) {
        PortfolioDashboardExample portfolioDashboardExample =new PortfolioDashboardExample();
        portfolioDashboardExample.createCriteria().andPortIdEqualTo(portID);
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardMapper.selectByExample(portfolioDashboardExample);
        return portfolioDashboards;
    }

    @Override
    public List<PortfolioDashboard> getByManagerId(int managerID) {
        PortfolioDashboardExample portfolioDashboardExample =new PortfolioDashboardExample();
        portfolioDashboardExample.createCriteria().andUserIdEqualTo(managerID);
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardMapper.selectByExample(portfolioDashboardExample);
        return portfolioDashboards;
    }

    @Override
    public List<PortfolioDashboard> getByPortfolioName(String portfolioName) {
        PortfolioDashboardExample portfolioDashboardExample =new PortfolioDashboardExample();
        portfolioDashboardExample.createCriteria().andPortNameLike("%"+portfolioName+"%");
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardMapper.selectByExample(portfolioDashboardExample);
        return portfolioDashboards;
    }

    @Override
    public Map<String,Double> sort(String... args) {
        Map<String, Double> unsortMap = new TreeMap<>();
        String orders = new ExampleFormatter<String>().formatSequence(args);
        PortfolioDashboardExample portfolioDashboardExample = new PortfolioDashboardExample();
        portfolioDashboardExample.setOrderByClause(orders);
        List<SystemUser> manager = systemUserService.getManager();
        for (SystemUser user :
                manager) {
            PortfolioDTO portfolioDTO = portfolioService.getByManager(user.getUserId(), null, null);
            List<Portfolio> portfolios = portfolioDTO.getPortfolios();
            Double totalValue = 0.0;
            for (Portfolio portfolio :
                    portfolios) {
                totalValue += portfolioService.calValue(portfolio);
            }
            unsortMap.put(user.getUserId().toString(),totalValue);
        }
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(unsortMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
            //升序排序
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<String,Double> sortedMap=new TreeMap<String, Double>();
        for (Map.Entry<String, Double> e: list) {
            sortedMap.put(e.getKey(),e.getValue());
        }
        return sortedMap;
    }

}
