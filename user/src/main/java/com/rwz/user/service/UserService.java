package com.rwz.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rwz.user.dao.entity.UserDO;

/**
 * @author rwz
 * @since 2025/6/12
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {

    void test();
}
