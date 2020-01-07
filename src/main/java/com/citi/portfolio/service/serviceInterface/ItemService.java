package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.dto.ItemDTO;
import com.citi.portfolio.model.CommoditiesExample;
import com.citi.portfolio.model.StocksExample;

import java.util.Date;

public interface ItemService{
    Double getPriceByDate(String type, String name, Date date);
    ItemDTO getItems(String select, String value, Integer from, Integer size, String... args);
    ItemDTO selectByStocksExample(StocksExample stocksExample);
    ItemDTO selectByCommExample(CommoditiesExample commoditiesExample);
    ItemDTO getStocks(String name, Integer from, Integer size, String... args);
    ItemDTO getComm(String name, Integer from, Integer size, String... args);
}
