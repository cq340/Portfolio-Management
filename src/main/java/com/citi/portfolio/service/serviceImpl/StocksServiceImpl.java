package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.StocksMapper;
import com.citi.portfolio.model.Stocks;
import com.citi.portfolio.model.StocksExample;
import com.citi.portfolio.service.serviceInterface.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StocksServiceImpl implements StocksService {
    @Autowired
    private StocksMapper stocksMapper;

    @Override
    public Double getPriceByDate(String name, Date date) {
        StocksExample stocksExample = new StocksExample();
        StocksExample.Criteria criteria = stocksExample.createCriteria();
        criteria.andStocksDateEqualTo(date);
        criteria.andStocksNameEqualTo(name);
        List<Stocks> stocks = stocksMapper.selectByExample(stocksExample);
        if (stocks != null && stocks.size() == 1)
            return stocks.get(0).getPrice();
        return null;
    }


    /**
     * 根据股票(大宗商品)名称和起始时间,终止时间来展示该金融商品价格变动
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<Double> getPriceTrend(String name, Date startDate, Date endDate) {
        List<Double> list = new ArrayList<>();
        StocksExample stocksExample = new StocksExample();
        StocksExample.Criteria criteria = stocksExample.createCriteria();
        criteria.andStocksNameEqualTo(name);
        criteria.andStocksDateBetween(startDate, endDate);
        List<Stocks> stocks = stocksMapper.selectByExample(stocksExample);

        for (Stocks stock : stocks) {
            list.add(stock.getPrice());
        }
        return list;
    }

    @Override
    public List<Stocks> getByName(String name) {
        StocksExample stocksExample = new StocksExample();
        StocksExample.Criteria criteria = stocksExample.createCriteria();
        criteria.andStocksNameLike("%"+name+"%");
        List<Stocks> list=stocksMapper.selectByExample(stocksExample);

        return list;
    }
}
