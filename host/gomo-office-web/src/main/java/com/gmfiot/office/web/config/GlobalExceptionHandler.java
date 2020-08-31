package com.gmfiot.office.web.config;

import com.gmfiot.core.StatusCodeEnum;
import com.gmfiot.core.data.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result globaException(HttpServletRequest request, Exception exception){
        logger.error(exception.getMessage());
        logger.error(exception.toString());
        Result result = Result.fail(StatusCodeEnum.SERVER_ERROR.getCode(), exception.getMessage());
        return result;
    }

    //    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
//        log.error("ExceptionHandler ===>" + e.getMessage());
//        e.printStackTrace();
//        // 这里可根据不同异常引起的类做不同处理方式
//        String exceptionName = ClassUtils.getShortName(e.getClass());
//        log.error("ExceptionHandler ===>" + exceptionName);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("stackTrace", e.getStackTrace());
//        mav.addObject("errorMessage", e.getMessage());
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("forward:/error/500");
//        return mav;
//    }
}
