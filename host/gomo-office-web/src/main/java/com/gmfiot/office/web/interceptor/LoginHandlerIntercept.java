package com.gmfiot.office.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerIntercept implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginHandlerIntercept.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if(username != null){
            return true;
        }else {
            request.setAttribute("login_error","请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }

    }
}
