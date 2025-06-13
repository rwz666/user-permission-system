package com.rwz.user.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author rwz
 * @since 2025/6/12
 * 用户实体类
 */
@Data
@TableName("user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {


    /**
     * 用户ID
     */
    private Long userId;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * phone
     */
    private String phone;

    /**
     * gmt_create
     */
    private Date createTime;

}