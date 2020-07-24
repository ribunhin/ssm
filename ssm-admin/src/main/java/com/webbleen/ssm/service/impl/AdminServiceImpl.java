package com.webbleen.ssm.service.impl;

import com.webbleen.ssm.entity.UmsAdmin;
import com.webbleen.ssm.mapper.UmsAdminMapper;
import com.webbleen.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UmsAdminMapper adminMapper;

    @Override
    public List<UmsAdmin> findAll() {
        return adminMapper.selectAll();
    }

    @Override
    public UmsAdmin findByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }
}
