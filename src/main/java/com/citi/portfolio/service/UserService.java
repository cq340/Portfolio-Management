package com.citi.portfolio.service;


import com.citi.portfolio.dao.UserDAO;
import com.citi.portfolio.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by changqing on 2018/8/13.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public SystemUser login(String username, String password) {
        SystemUser user = userDAO.checkLogin(username, password);
        return user;
    }

}
