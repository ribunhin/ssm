package com.webbleen.ssm.service.impl;

import com.webbleen.ssm.entity.UmsAdmin;
import com.webbleen.ssm.service.AdminCacheService;
import org.springframework.stereotype.Service;

@Service
public class AdminCacheServiceImpl implements AdminCacheService {
    @Override
    public void setAdmin(UmsAdmin admin) {

    }

    @Override
    public UmsAdmin getAdmin(String username) {
        return null;
    }

    @Override
    public void delAdmin(Long adminId) {

    }
}
