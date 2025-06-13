package com.rwz.user.dto.req;

import lombok.Data;

/**
 * @author rwz
 * @since 2025/6/11
 * 用户注册请求参数
 */
@Data
public class UserRegisterReqDTO {

    private String username;

    private String password;

    private String email;

    private String phone;

}
