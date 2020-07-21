package com.webbleen.ssm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: ums_admin
 */
@Data
public class UmsAdmin implements Serializable {
    /**
     * Column:    id
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  false
     * AutoIncrement:  true
     */
    private Long id;

    /**
     * Column:    username
     * Length:    64
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String username;

    /**
     * Column:    password
     * Length:    64
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String password;

    /**
     * 头像
     *
     * Column:    icon
     * Length:    500
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String icon;

    /**
     * 邮箱
     *
     * Column:    email
     * Length:    100
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String email;

    /**
     * 昵称
     *
     * Column:    nick_name
     * Length:    200
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String nickName;

    /**
     * 备注信息
     *
     * Column:    note
     * Length:    500
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private String note;

    /**
     * 创建时间
     *
     * Column:    create_time
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 最后登录时间
     *
     * Column:    login_time
     * Length:    19
     * DefaultValue:  无默认值
     * Nullable:  true
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     *
     * Column:    status
     * Length:    10
     * DefaultValue:  1
     * Nullable:  true
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}