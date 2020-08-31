package com.gmfiot.office.internal.api.config;

import com.gmfiot.core.StatusCodeEnum;
import com.gmfiot.core.data.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> globalException(HttpServletRequest request, Exception exception){
        logger.error(exception.getMessage(),exception);
        Result result = Result.fail(StatusCodeEnum.SERVER_ERROR.getCode(), exception.getMessage());
        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }
}
