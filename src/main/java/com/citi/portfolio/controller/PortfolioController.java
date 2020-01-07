package com.citi.portfolio.controller;

import com.citi.portfolio.dto.PortfolioDTO;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @PostMapping
    public Response add(@RequestParam("managerID")Integer mID,
                        @RequestParam("cash")Double cash,
                        @RequestParam("name")String name){
        Portfolio portfolio = new Portfolio();
        portfolio.setManagerId(mID);
        portfolio.setCash(cash);
        portfolio.setPortName(name);
        portfolioService.add(portfolio);
        return ResponseUtil.success();
    }

    @GetMapping("/{managerID}")
    public Response get(@PathVariable("managerID") Integer mID,
                        @RequestParam(name = "from", defaultValue = "0",required = false) Integer from,
                        @RequestParam(name = "size", defaultValue = "10",required = false) Integer size,
                        @RequestParam(name = "order_type",required = false) String orderType,
                        @RequestParam(name = "sequence",required = false) String sequence){
        PortfolioDTO portfolioDTO = portfolioService.getByManager(mID, from, size, orderType, sequence);
        return ResponseUtil.success(portfolioDTO);
    }

    @GetMapping("/initvalue/{portId}")
    public Response getInitValue(@PathVariable("portId") Integer portId){
        Portfolio portfolio = portfolioService.getById(portId);
        Double initValue = portfolioService.getInitValue(portfolio);
        return ResponseUtil.success(initValue);
    }

    @PostMapping("/manager")
    public Response changeManager(@RequestParam("former_mid")Integer formerID,
                                  @RequestParam("current_mid")Integer curId,
                                  @RequestParam("port_id")Integer portId){
        portfolioService.changeManager(formerID,curId,portId);
        return ResponseUtil.success();
    }

}
