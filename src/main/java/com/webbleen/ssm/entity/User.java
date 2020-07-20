package com.webbleen.ssm.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author webbleen
 * @since 2020-07-07
 */
@Data
public class User {

    private Long id;

    private String avatar;

    private Date birthday;

    private Date createTime;

    private String email;

    private String gender;

    private String password;

    private String brief;

    private String phone;

    private String nickname;

    private Integer type;

    private Date updateTime;

    private String username;


}
