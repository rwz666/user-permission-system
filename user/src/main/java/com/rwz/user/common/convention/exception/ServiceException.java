package com.rwz.user.common.convention.exception;

import com.rwz.user.common.convention.errorcode.BaseErrorCode;
import lombok.Getter;

/**
 * @author rwz
 * @since 2025/6/13
 * 服务端异常
 */
@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -6743880560617024289L;

    public final String errorCode;

    public final String errorMessage;

    public ServiceException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String message) {
        this.errorCode = BaseErrorCode.SERVICE_ERROR.getErrorCode();
        this.errorMessage = message;
    }

    public ServiceException() {
        this.errorCode = BaseErrorCode.SERVICE_ERROR.getErrorCode();
        this.errorMessage = BaseErrorCode.SERVICE_ERROR.getDesc();
    }

}
