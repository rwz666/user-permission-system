package com.rwz.user.util;

import cn.hutool.jwt.JWT;

/**
 * @author rwz
 * @since 2025/6/13
 * jwt工具类
 */
public class JWTUtil {

    private static final byte[] key = "123123123".getBytes();

    public static String generateToken(String userId, String username) {
        return JWT.create()
                .setPayload("userId", userId)
                .setPayload("username", username)
                .setKey(key)
                .sign();
    }

    /**
     * 验证jwt是否被修改
     * @param token jwt
     * @return 是否被修改
     */
    public static Boolean verifyToken(String token) {
        try{
            return JWT.of(token).setKey(key).verify();
        }catch (Exception e) {
            return false;
        }
    }
}
