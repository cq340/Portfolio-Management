package com.citi.portfolio.service;


import com.citi.portfolio.dao.PortfolioMapper;
import com.citi.portfolio.dao.StocksMapper;
import com.citi.portfolio.dao.SystemUserMapper;
import com.citi.portfolio.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private SystemUserMapper userMapper;
    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private StocksMapper stocksMapper;

    public List<SystemUser> get(){
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        List<SystemUser> users = userMapper.selectByExample(example);
        return users;
    }

    public List<Portfolio> getP(){
        PortfolioExample portfolioExample = new PortfolioExample();
        List<Portfolio> portfolios = portfolioMapper.selectByExample(portfolioExample);
        return portfolios;
    }

    public List<Stocks> getS(){
        StocksExample stocksExample = new StocksExample();
        return stocksMapper.selectByExample(stocksExample);
    }
}
