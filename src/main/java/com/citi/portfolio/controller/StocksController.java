package com.citi.portfolio.controller;

import com.citi.portfolio.model.Stocks;
import com.citi.portfolio.service.serviceImpl.StocksServiceImpl;
import com.citi.portfolio.service.serviceInterface.StocksService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/stocks")
public class StocksController {
    @Autowired
    StocksService stocksService;


    @GetMapping("/{name}")
    public Response get(@PathVariable("name")String stockName,
                        @RequestParam(name = "startDate", required = true)Date startDate,
                        @RequestParam(name = "endDate", required = true)Date endDate){
        List<Double> stockPrice=stocksService.getPriceTrend(stockName,startDate,endDate);
        return ResponseUtil.success(stockPrice);
    }

    @GetMapping("/searchStock/{like}")
    public Response search(@PathVariable("like")String like){
        List<Stocks> stock=stocksService.getByName(like);
        return ResponseUtil.success(stock);
    }


}
