package com.rwz.user.controller;

import com.rwz.user.common.convention.result.Result;
import com.rwz.user.common.convention.result.Results;
import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.dto.req.UserLoginReqDTO;
import com.rwz.user.dto.req.UserRegisterReqDTO;
import com.rwz.user.dto.resp.UserLoginRespDTO;
import com.rwz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rwz
 * @since 2025/6/12
 * 用户控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/test")
    public String test() {
        userService.test();
        return "test";
    }

    /**
     * 用户注册
     */
    @PostMapping("/user/register")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }
}
