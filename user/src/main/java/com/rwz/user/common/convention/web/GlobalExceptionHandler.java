package com.rwz.user.common.convention.web;

import com.rwz.user.common.convention.exception.AbstractException;
import com.rwz.user.common.convention.exception.ServiceException;
import com.rwz.user.common.convention.result.Result;
import com.rwz.user.common.convention.result.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.AbstractErrors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rwz
 * @since 2025/6/13
 * 全局异常拦截器
 */
@Component
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AbstractException.class)
    public Result serviceException(HttpServletRequest request, AbstractException e) {
        log.error("[{}] {} [ex] {}", request.getMethod(), request.getRequestURI(), e, e.getCause());
        return Results.fail(e);
    }
}
