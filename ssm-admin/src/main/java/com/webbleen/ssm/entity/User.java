package com.webbleen.ssm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: w_user
 */
@Data
public class User implements Serializable {
    /**
     * Column:    id
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  false
     * AutoIncrement:  true
     */
    private Long id;

    /**
     * Column:    avatar
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String avatar;

    /**
     * Column:    birthday
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date birthday;

    /**
     * Column:    brief
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String brief;

    /**
     * Column:    create_time
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date createTime;

    /**
     * Column:    email
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String email;

    /**
     * Column:    gender
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String gender;

    /**
     * Column:    nickname
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String nickname;

    /**
     * Column:    password
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String password;

    /**
     * Column:    phone
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String phone;

    /**
     * Column:    type
     * Length:    10
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Integer type;

    /**
     * Column:    update_time
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * Column:    username
     * Length:    255
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String username;

    private static final long serialVersionUID = 1L;
}