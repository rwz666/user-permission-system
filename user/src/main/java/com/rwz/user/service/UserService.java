package com.rwz.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.dto.req.UserRegisterReqDTO;

/**
 * @author rwz
 * @since 2025/6/12
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {

    void test();

    /**
     * 用户注册
     * @param requestParam 用户注册请求参数
     */
    void register(UserRegisterReqDTO requestParam);
}
