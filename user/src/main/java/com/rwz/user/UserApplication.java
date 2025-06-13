package com.rwz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author rwz
 * @since 2025/6/11
 * 用户管理启动类
 */
@SpringBootApplication
@MapperScan("com.rwz.user.dao.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
