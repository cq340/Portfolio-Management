package com.citi.portfolio.controller;


import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.service.UserService;
import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;
import com.citi.response.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.citi.response.util.ResponseUtil.error;
import static com.citi.response.util.ResponseUtil.success;

@RestController
@RequestMapping("/login")
public class LogController {
    @Autowired
    private UserService userService;

    @GetMapping("/error")
    public Response unLogged(){
        return ResponseUtil.error(ResponseEnum.NOT_LOG);
    }

    /**
     * Case success, find user from database
     * Check the password
     * Update the cookie if it passed
     * Return the user objec for redirecting
     * @param response to set cookie
     * @return
     */
    @PostMapping
    public Response login(HttpServletResponse response,
                          @RequestParam(value = "id")String userName,
                          @RequestParam(value = "password") String passwd){
        SystemUser user = userService.login(userName, passwd);
        if (user != null && user.getUserId() != null) {
            Integer userId = user.getUserId();
            Cookie cookie = new Cookie("ticket", userId.toString());
            Cookie role_cookie = new Cookie("role", user.getRole());
            response.addCookie(cookie);
            response.addCookie(role_cookie);
            user.setPassword("");
            return success(user);
        }

        return error(ResponseEnum.LOGIN_FAIL);
    }
}
