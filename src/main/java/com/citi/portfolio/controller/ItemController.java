package com.citi.portfolio.controller;

import com.citi.portfolio.dto.ItemDTO;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.service.serviceInterface.ItemService;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public Response get(@RequestParam(name = "from", defaultValue = "0",required = false) Integer from,
                        @RequestParam(name = "size", defaultValue = "10",required = false) Integer size,
                        @RequestParam(name = "order_type",required = false) String orderType,
                        @RequestParam(name = "sequence",required = false) String sequence,
                        @RequestParam(name = "portId")Integer portId,//to show current cash of portfolio
                        @RequestParam(name = "select")String select,//1 name 2type
                        @RequestParam(name = "value")String value){
        ItemDTO items = itemService.getItems(select, value, from, size, orderType, sequence);
        //get the current portfolio value to show
        Portfolio portfolio = portfolioService.getById(portId);
        items.setCurCash(portfolio.getCash());
        return ResponseUtil.success(items);
    }
}
