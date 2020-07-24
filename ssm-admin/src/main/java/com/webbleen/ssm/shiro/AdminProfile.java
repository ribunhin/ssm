package com.webbleen.ssm.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminProfile implements Serializable {

    private Long id;

    private String username;

    private String icon;

    private String email;

}
