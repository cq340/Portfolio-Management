package com.citi.portfolio.controller;

import com.citi.portfolio.dto.PerformanceDTO;
import com.citi.portfolio.model.ManagerPerformance;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.model.UserItem;
import com.citi.portfolio.service.serviceInterface.EditManagerService;
import com.citi.portfolio.service.serviceInterface.ManagerPerformanceService;
import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by changqing on 2018/8/15.
 */
@RestController
public class FundManagerController {
    @Autowired
    private EditManagerService editManagerService;

    @Autowired
    private ManagerPerformanceService managerPerformanceService;

    @Autowired
    private SystemUser systemUser;


    @PostMapping("/manager")
    public Response addFundManager(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("tel") int tel) {
        SystemUser user = editManagerService.add(name, tel, password);
        if (user == null) {
            return ResponseUtil.error(ResponseEnum.USER_INSERT_FAIL);
        }
        return ResponseUtil.success();
    }

    @PutMapping("/manager/{id}")
    public Response addFundManager(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("tel") int tel) {
        boolean flag = editManagerService.modify(id, name, tel, password);
        if (!flag) {
            return ResponseUtil.error(ResponseEnum.USER_MODIFY_FAIL);
        }
        return ResponseUtil.success();
    }


    @DeleteMapping("/manager/{id}")
    public Response deleteFundManager(@PathVariable("id") int id) {
        boolean flag = editManagerService.delete(id);
        if (!flag) {
            return ResponseUtil.error(ResponseEnum.USER_DELETE_FAIL);
        }
        return ResponseUtil.success();
    }


    @GetMapping("/manager")
    public Response getFundManager(
            @RequestParam(name = "from", defaultValue = "0", required = false) Integer from,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(name = "order_type", required = false) String orderType,
            @RequestParam(name = "sequence", required = false) String sequence) {
        PerformanceDTO performance = managerPerformanceService.getPerformance(from, size, orderType, sequence);
        return ResponseUtil.success(performance);
    }


    @GetMapping("/managerRanks")
    public Response getFundManagerRank() {
        List<SystemUser> systemUsers = editManagerService.get();
        List<UserItem> userList = new ArrayList<>();
        for (SystemUser manager : systemUsers) {
            UserItem user=new UserItem();
            ManagerPerformance performance = managerPerformanceService.getPerformance(manager.getUserId());
            user.setUserId(manager.getUserId());
            user.setUserName(manager.getUserName());
            user.setTel(manager.getTel());
            user.setRole(manager.getRole());
            user.setPercent(new BigDecimal(performance.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            userList.add(user);
        }
        Collections.sort(userList, (o1, o2) -> {
            if (o2.getPercent() - o1.getPercent() >= 0) {
                return 1;
            }
            return -1;
        });
//        userList= userList.subList(0, 3);
        return ResponseUtil.success(userList);
    }
}
