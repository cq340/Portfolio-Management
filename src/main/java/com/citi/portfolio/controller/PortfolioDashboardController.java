package com.citi.portfolio.controller;


import com.citi.portfolio.model.PortfolioDashboard;
import com.citi.portfolio.service.serviceInterface.PortfolioDashboardService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolioDashboard")
public class PortfolioDashboardController {
    @Autowired
    private PortfolioDashboardService portfolioDashboardService;

    @GetMapping("/{portID}")
    public Response getP(@PathVariable("portID") Integer portID){
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardService.getByPortId(portID);
        return ResponseUtil.success(portfolioDashboards);
    }

    @GetMapping("/manager/{managerID}")
    public Response getM(@PathVariable("managerID") Integer managerID){
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardService.getByManagerId(managerID);
        return ResponseUtil.success(portfolioDashboards);
    }

    @GetMapping("/portfolioname/{portfolioName}")
    public Response getPM(@PathVariable("portfolioName") String portfolioName){
        List<PortfolioDashboard> portfolioDashboards=portfolioDashboardService.getByPortfolioName(portfolioName);
        return ResponseUtil.success(portfolioDashboards);
    }

    @GetMapping("/sortmanager/{sort}")
    public Response sortPM(@PathVariable("sort") String sort){
        Map<String,Double> sortedMap=portfolioDashboardService.sort(sort);
        return ResponseUtil.success(sortedMap);
    }


}
