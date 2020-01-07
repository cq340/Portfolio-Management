package com.citi.portfolio.controller;

import com.citi.portfolio.service.TestService;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.citi.response.entity.Response;

import static com.citi.response.util.ResponseUtil.success;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping
    public Response getJson(){
        return success(testService.get());
    }

    @DeleteMapping
    public Response putError(){
        return ResponseUtil.error(404,"ErrorTest");
    }

}
