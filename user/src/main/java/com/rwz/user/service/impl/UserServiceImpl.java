package com.rwz.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.dao.mapper.UserMapper;
import com.rwz.user.dto.req.UserRegisterReqDTO;
import com.rwz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public void register(UserRegisterReqDTO requestParam) {

        //todo: rpc调用绑定默认角色

        //todo: 发送日志消息至MQ

        // 3.保存到数据库
        UserDO userDO = UserDO.builder()
                .username(requestParam.getUsername())
                .email(requestParam.getEmail())
                .phone(requestParam.getPhone())
                .createTime(new Date())
                .build();
        userMapper.insert(userDO);
    }
}
