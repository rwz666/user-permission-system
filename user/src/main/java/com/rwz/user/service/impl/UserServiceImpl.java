package com.rwz.user.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rwz.user.common.convention.exception.ClientException;
import com.rwz.user.common.convention.exception.ServiceException;
import com.rwz.user.dao.entity.UserDO;
import com.rwz.user.dao.mapper.UserMapper;
import com.rwz.user.dto.req.UserLoginReqDTO;
import com.rwz.user.dto.req.UserRegisterReqDTO;
import com.rwz.user.dto.resp.UserLoginRespDTO;
import com.rwz.user.service.UserService;
import com.rwz.user.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author rwz
 * @since 2025/6/12
 * 用户接口实现层
 */
@Slf4j
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
        // 判断是否已经注册过
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getEmail, requestParam.getEmail());
        UserDO dbUser = userMapper.selectOne(queryWrapper);
        if (dbUser != null) {
            throw new ServiceException("该邮箱已注册！");
        }

        // 保存到数据库
        // 雪花算法生成id
        long userId = IdUtil.getSnowflakeNextId();
        UserDO userDO = UserDO.builder()
                .userId(userId)
                .username(requestParam.getUsername())
                .password(requestParam.getPassword())
                .email(requestParam.getEmail())
                .phone(requestParam.getPhone())
                .createTime(new Date())
                .build();
        userMapper.insert(userDO);
        log.info("用户注册成功 ID：{}，email：{}", userId, requestParam.getEmail());
        //todo: rpc调用绑定默认角色

        //todo: 发送日志消息至MQ
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword());
        UserDO userDO = userMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException("用户名或密码错误");
        }
        String token = JWTUtil.generateToken(userDO.getUserId().toString(), userDO.getUsername());
        return new UserLoginRespDTO(token);
    }
}
