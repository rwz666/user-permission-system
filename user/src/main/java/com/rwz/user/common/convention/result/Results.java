package com.rwz.user.common.convention.result;

import com.rwz.user.common.convention.errorcode.BaseErrorCode;

/**
 * @author rwz
 * @since 2025/6/13
 * 返回结果封装
 */
public class Results {

    /**
     * 成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 失败响应
     */
    public static Result<Void> fail() {
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVICE_ERROR.getErrorCode())
                .setCode(BaseErrorCode.SERVICE_ERROR.getErrorCode());
    }
}
