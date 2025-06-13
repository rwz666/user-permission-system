package com.rwz.user.dto.req;

import lombok.Data;

/**
 * @author rwz
 * @since 2025/6/13
 * 用户登录请求实体
 */
@Data
public class UserLoginReqDTO {

    private String username;

    private String password;
}
