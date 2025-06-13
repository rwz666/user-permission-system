package com.rwz.user.controller;

import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
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
}
