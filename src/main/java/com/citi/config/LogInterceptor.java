package com.citi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogInterceptor implements HandlerInterceptor {
    /**
     * Check user's log status before he access the url
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0)
            //check weather user is logged
            for (Cookie tmp :
                    cookies) {
                if (tmp.getName().equals("ticket"))//ticket is user's ID
                    if (tmp.getValue() == null || tmp.getValue().equals(""))
                        break;//only when cookie named ticket exists&empty
                if (tmp.getName().equals("role"))//role is user's type, admin or manager
                    if (tmp.getValue()!=null && tmp.getValue()!="")
                        if (tmp.getValue().equals("admin") || tmp.getValue().equals("manager"))
                            return true;
                        else
                            break;//if the user not either admin or manager, make him relog
            }
        response.sendRedirect(request.getContextPath() + "/login/error");
        return false;
    }
}
