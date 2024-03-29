package com.gmfiot.office.internal.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Exception e = new Exception();
        //处理 UndeclaredThrowableException
        if (ex instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
        } else {
            e = ex;
        }
        e.printStackTrace();
        //这里可以根据不同异常引起的类做不同处理方式
        String exceptionName = ClassUtils.getShortName(e.getClass());
        if(exceptionName.equals("ArrayIndexOutOfBoundsException")) {
            logger.error("GlobalHandlerExceptionResolver resolveException ===>" + exceptionName);
            ModelAndView mav = new ModelAndView();
            mav.addObject("stackTrace", e.getStackTrace());
            mav.addObject("exceptionName", exceptionName);
            mav.addObject("errorMessage", e.getMessage());
            mav.addObject("url", request.getRequestURL());
            mav.setViewName("forward:/error/500");
            return mav;
        }
        return null;
    }
}
