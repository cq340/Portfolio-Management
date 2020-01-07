package com.citi.portfolio.controller;

import com.citi.portfolio.model.ManagerPerformance;
import com.citi.portfolio.service.serviceInterface.ManagerPerformanceService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    private ManagerPerformanceService managerPerformanceService;

    @GetMapping("/{id}")
    public Response get(@PathVariable("id")Integer mID){
        ManagerPerformance performance = managerPerformanceService.getPerformance(mID);
        return ResponseUtil.success(performance);
    }
}
