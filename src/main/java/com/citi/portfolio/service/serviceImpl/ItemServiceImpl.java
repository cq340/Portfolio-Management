package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.CommoditiesMapper;
import com.citi.portfolio.dao.StocksMapper;
import com.citi.portfolio.dto.ItemDTO;
import com.citi.portfolio.model.Commodities;
import com.citi.portfolio.model.CommoditiesExample;
import com.citi.portfolio.model.Stocks;
import com.citi.portfolio.model.StocksExample;
import com.citi.portfolio.service.serviceInterface.ItemService;
import com.citi.portfolio.util.ExampleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private StocksMapper stocksMapper;
    @Autowired
    private CommoditiesMapper commoditiesMapper;
    @Override
    public Double getPriceByDate(String type,String name, Date date) {
        if (type.equals("stocks")) {
            StocksExample stocksExample = new StocksExample();
            StocksExample.Criteria criteria = stocksExample.createCriteria();
            criteria.andStocksDateEqualTo(date);
            criteria.andStocksNameEqualTo(name);
            List<Stocks> stocks = stocksMapper.selectByExample(stocksExample);
            if (stocks != null && stocks.size() == 1)
                return stocks.get(0).getPrice();
        }else if (type.equals("commodities")){
            CommoditiesExample commoditiesExample = new CommoditiesExample();
            CommoditiesExample.Criteria criteria = commoditiesExample.createCriteria();
            criteria.andCommDateEqualTo(date);
            criteria.andCommoditiesNameEqualTo(name);
            List<Commodities> commodities = commoditiesMapper.selectByExample(commoditiesExample);
            if (commodities != null && commodities.size() == 1)
                return commodities.get(0).getPrice();
        }
        return null;
    }

    /**
     * @param select 1 name 2type
     * @param value
     * @param from
     * @param size
     * @param args order sequence
     * @return
     */
    @Override
    public ItemDTO getItems(String select, String value, Integer from, Integer size, String... args) {
        ItemDTO itemDTO = null;
        switch (select){
            case "1"://name
                ItemDTO tmp1= getStocks(value, from, size, args);
                ItemDTO tmp2 = getComm(value, from, size, args);
                //consider the name cant be appear at
                // commodities and stocks at the same time
                if(tmp1 != null && tmp1.getSize()>0)
                    itemDTO = tmp1;
                else
                    itemDTO = tmp2;
                break;
            case "2"://type
                //then choose which type of items to operate
                switch (value){
                    case "stocks":
                        itemDTO = getStocks(null, from, size, args);
                        break;
                    case "commodities":
                        itemDTO = getComm(null, from, size, args);
                        break;
                }
                break;
        }
        return itemDTO;
    }

    @Override
    public ItemDTO selectByStocksExample(StocksExample stocksExample) {
        List<Object> stocks = Collections.singletonList(stocksMapper.selectByExample(stocksExample));
        ItemDTO stocksItemDTO = new ItemDTO();
        stocksItemDTO.setList(stocks);
        stocksItemDTO.setSize(stocksMapper.countByExample(stocksExample));
        return stocksItemDTO;
    }

    @Override
    public ItemDTO selectByCommExample(CommoditiesExample commoditiesExample) {
        List<Object> commodities = Collections.singletonList(commoditiesMapper.selectByExample(commoditiesExample));
        ItemDTO commItemDTO = new ItemDTO();
        commItemDTO.setList(commodities);
        commItemDTO.setSize(commoditiesMapper.countByExample(commoditiesExample));
        return commItemDTO;
    }

    @Override
    public ItemDTO getStocks(String name, Integer from, Integer size, String... args) {
        StocksExample stocksExample = new StocksExample();
        StocksExample.Criteria criteria = stocksExample.createCriteria();
        if (name != null && !name.equals(""))
            criteria.andStocksNameEqualTo(name);
        //ordered the result
        String order = new ExampleFormatter<String>().formatSequence(args);
        if (order != null && !order.trim().equals(""))
            stocksExample.setOrderByClause(order);
        //paging
        stocksExample.setStartRow(from);
        stocksExample.setPageSize(size);
        criteria.andStocksDateEqualTo(new Date());
        return selectByStocksExample(stocksExample);
    }

    @Override
    public ItemDTO getComm(String name, Integer from, Integer size, String... args) {
        CommoditiesExample commoditiesExample = new CommoditiesExample();
        CommoditiesExample.Criteria criteria = commoditiesExample.createCriteria();
        if (name != null && !name.equals(""))
            criteria.andCommoditiesNameEqualTo(name);
        //ordered the result
        String order = new ExampleFormatter<String>().formatSequence(args);
        if (order != null && !order.trim().equals(""))
            commoditiesExample.setOrderByClause(order);
        //paging
        commoditiesExample.setStartRow(from);
        commoditiesExample.setPageSize(size);
        criteria.andCommDateEqualTo(new Date());
        return selectByCommExample(commoditiesExample);
    }

}
