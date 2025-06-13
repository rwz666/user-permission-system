package com.rwz.user.common.convention.exception;

import com.rwz.user.common.convention.errorcode.BaseErrorCode;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author rwz
 * @since 2025/6/13
 * 异常抽象类
 */
public class AbstractException extends RuntimeException {

    private static final long serialVersionUID = -9220205385604406338L;

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, BaseErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.getDesc());
    }
}
