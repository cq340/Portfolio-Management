package com.citi.portfolio.controller;

import com.citi.portfolio.dto.PositionDTO;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.Position;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.portfolio.service.serviceInterface.PositionService;
import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositioinController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/portfolio/{id}")
    public Response getByPortId(@PathVariable("id")Integer portId,
                                @RequestParam(name = "from", defaultValue = "0",required = false) Integer from,
                                @RequestParam(name = "size", defaultValue = "10",required = false) Integer size,
                                @RequestParam(name = "order_type",required = false) String orderType,
                                @RequestParam(name = "sequence",required = false) String sequence){
        PositionDTO positions = positionService.getPositions(portId, from, size, orderType, sequence);
        Portfolio portfolio = portfolioService.getById(portId);
        positions.setCurrentCash(portfolio.getCash());
        return ResponseUtil.success(positions);
    }
    @GetMapping("/{id}")
    public Response get(@PathVariable("id")Integer positionId){
        Position position = positionService.getById(positionId);
        return ResponseUtil.success(position);
    }

    @PostMapping
    public Response add(@RequestParam("portfolio_id")Integer portId,
                        @RequestParam("name")String itemName,
                        @RequestParam("qty")Integer qty,
                        @RequestParam("type")String type,
                        @RequestParam(name = "date", required = false)Date date){
        Position position = new Position();
        if (date == null)
            date = new Date();
        position.setPositionDate(date);
        position.setItemName(itemName);
        position.setQty(qty);
        position.setPortId(portId);
        Boolean success = positionService.add(position, type);
        if (success)
            return ResponseUtil.success();
        else
            return ResponseUtil.error(ResponseEnum.CASH_FAIL);
    }

    @PostMapping("/sell")
    public Response sell(@RequestParam("position_id")Integer positionId,
                         @RequestParam("qty")Integer qty,
                         @RequestParam("type")String type,
                         @RequestParam(name = "date", required = false)Date date){
        Position position = new Position();
        if (date == null)
            date = new Date();
        position.setPositionDate(date);//just to pass param
        position.setQty(qty);//just to pass param, not real qty
        position.setPositionId(positionId);
        Boolean success = positionService.sell(position, type);
        if (success)
            return ResponseUtil.success();
        return ResponseUtil.error(ResponseEnum.QTY_FAIL);
    }
}
