package com.webbleen.ssm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private Date birthday;

    /**
     * 
     */
    private String brief;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String username;

    private static final long serialVersionUID = 1L;
}