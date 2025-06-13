package com.rwz.user.common.convention.exception;

import com.rwz.user.common.convention.errorcode.BaseErrorCode;

/**
 * @author rwz
 * @since 2025/6/13
 * 客户端异常
 */

public class ClientException extends AbstractException{

    private static final long serialVersionUID = 8535277196647072492L;

    public ClientException(String message, BaseErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }


    public ClientException(String message, Throwable throwable, BaseErrorCode baseErrorCode) {
        super(message, throwable, baseErrorCode);
    }
}
