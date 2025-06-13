package com.rwz.user.common.convention.errorcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author rwz
 * @since 2025/6/13
 * 基本错误码
 */
@Getter
public enum BaseErrorCode {

    SERVICE_ERROR("A00001", "服务端异常"),
    CLIENT_ERROR("B00001", "用户端错误");

    private final String errorCode;
    private final String desc;

    BaseErrorCode(String errorCode, String desc) {
        this.errorCode = errorCode;
        this.desc = desc;
    }
}
