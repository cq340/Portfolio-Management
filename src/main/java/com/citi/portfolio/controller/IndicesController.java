package com.citi.portfolio.controller;

import com.citi.portfolio.model.Indices;
import com.citi.portfolio.service.serviceInterface.IndicesService;
import com.citi.response.entity.Response;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/indices")
public class IndicesController {
    @Autowired
    private IndicesService indicesService;

    @GetMapping
    public Response get(){
        Date date = new Date();
        if (date == null)
            date = new Date();
        List<Indices> indices = indicesService.get(date);
        return ResponseUtil.success(indices);
    }
}
