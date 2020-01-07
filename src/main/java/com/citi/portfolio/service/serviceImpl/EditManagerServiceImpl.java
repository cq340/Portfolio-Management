package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.SystemUserMapper;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.model.SystemUserExample;
import com.citi.portfolio.service.serviceInterface.EditManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by changqing on 2018/8/15.
 */
@Service
@Component
public class EditManagerServiceImpl implements EditManagerService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemUser systemUser;

    @Override
    public SystemUser add(String name, int tel, String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return null;
        }
        systemUser.setUserName(name);
        systemUser.setTel(tel);
        systemUser.setPassword(password);
        systemUser.setRole("manager");
        systemUserMapper.insertSelective(systemUser);
        return systemUser;
    }


    @Override
    public boolean modify(int managerID, String name, int tel, String password) {
        SystemUser user = systemUserMapper.selectByPrimaryKey(managerID);
        user.setUserName(name);
        user.setTel(tel);
        user.setPassword(password);
        int n = systemUserMapper.updateByPrimaryKey(user);
        if (n == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int managerID) {
        int n = systemUserMapper.deleteByPrimaryKey(managerID);
        if (n == 0) {
            return false;
        }
        return true;
    }

    @Override
    public java.util.List<SystemUser> get() {
        SystemUserExample systemUserExample=new SystemUserExample();
        systemUserExample.createCriteria().andRoleEqualTo("manager");
        List<SystemUser> systemUsers = systemUserMapper.selectByExample(systemUserExample);
        return systemUsers;
    }
}
