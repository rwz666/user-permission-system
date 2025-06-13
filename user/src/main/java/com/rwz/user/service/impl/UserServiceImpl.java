package com.rwz.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.dao.mapper.UserMapper;
import com.rwz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author rwz
 * @since 2025/6/12
 * 用户接口实现层
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final UserMapper userMapper;

    @Override
    public void test() {
        UserDO userDO = UserDO.builder()
                .email("3113")
                .phone("213")
                .username("zhangsan")
                .userId(123131L).build();
        userMapper.insert(userDO);
    }
}
