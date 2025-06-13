package com.rwz.user.common.convention.exception;

import com.rwz.user.common.convention.errorcode.BaseErrorCode;
import lombok.Getter;

/**
 * @author rwz
 * @since 2025/6/13
 * 服务端异常
 */
@Getter
public class ServiceException extends AbstractException {

    private static final long serialVersionUID = -6743880560617024289L;

    public ServiceException(String message, BaseErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }


    public ServiceException(String message, Throwable throwable, BaseErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

}
