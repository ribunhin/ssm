package com.webbleen.ssm.service;

import com.webbleen.ssm.entity.UmsAdmin;

import java.util.List;

public interface AdminService {
    List<UmsAdmin> findAll();

    UmsAdmin findByUsername(String username);
}
