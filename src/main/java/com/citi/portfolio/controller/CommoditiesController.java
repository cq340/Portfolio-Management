package com.citi.portfolio.controller;


import com.citi.portfolio.model.Commodities;
import com.citi.portfolio.service.serviceInterface.CommoditiesService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commodities")
public class CommoditiesController {
    @Autowired
    CommoditiesService commoditiesService;
    @GetMapping("/{name}")
    public Response get(@PathVariable("name")String stockName,
                        @RequestParam(name = "startDate", required = true)Date startDate,
                        @RequestParam(name = "endDate", required = true)Date endDate){
        List<Double> stockPrice=commoditiesService.getPriceTrend(stockName,startDate,endDate);
        return ResponseUtil.success(stockPrice);
    }

    @GetMapping("/searchCommodities/{like}")
    public Response search(@PathVariable("like")String like){
        List<Commodities> commodity=commoditiesService.getByName(like);
        return ResponseUtil.success(commodity);
    }
}
