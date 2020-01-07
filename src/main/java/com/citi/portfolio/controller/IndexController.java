package com.citi.portfolio.controller;

import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.service.TestService;
import com.citi.portfolio.service.UserService;
import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.citi.response.util.ResponseUtil.error;
import static com.citi.response.util.ResponseUtil.success;


@RestController
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET})
    @ResponseBody
    public String index(HttpSession httpSession) {
        logger.info("VISIT HOME");
        String string = "终于好了";
        return string;
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(path = {"/login"}, method = {RequestMethod.GET})
    @ResponseBody
    public Response test(HttpServletResponse response, @RequestParam("username") String userName, @RequestParam("password") String password) {
        SystemUser user = userService.login(userName, password);
        if (user.getUserId() != null) {
            Integer userId = user.getUserId();
            Cookie cookie = new Cookie("ticket", userId.toString());
            cookie.setPath("/");
            response.addCookie(cookie);
            return success();
        }

        return error(ResponseEnum.LOGIN_FAIL);
    }

}




