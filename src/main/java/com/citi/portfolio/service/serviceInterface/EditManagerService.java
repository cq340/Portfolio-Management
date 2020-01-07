package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.model.SystemUser;

import java.util.List;

/**
 * Created by changqing on 2018/8/15.
 */

public interface EditManagerService {
    SystemUser add(String name,int tel,String password);
    boolean modify(int managerID,String name,int tel,String password);
    boolean delete(int managerID);
    List<SystemUser> get();
}
