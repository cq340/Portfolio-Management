package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.SystemUserMapper;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.model.SystemUserExample;
import com.citi.portfolio.service.serviceInterface.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private SystemUserMapper userMapper;

    /**
     * 登录判断
     * @param userName
     * @param passwd
     * @return
     */
    @Override
    public boolean checkPasswd(String userName, String passwd) {
        SystemUserExample userExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(passwd);
        List<SystemUser> users = userMapper.selectByExample(userExample);
        if (users.size()==1)
            return true;
        return false;
    }
}
