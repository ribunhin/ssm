package com.webbleen.ssm.service.impl;

import com.webbleen.ssm.entity.UmsAdmin;
import com.webbleen.ssm.entity.UmsAdminExample;
import com.webbleen.ssm.mapper.UmsAdminMapper;
import com.webbleen.ssm.service.AdminCacheService;
import com.webbleen.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private AdminCacheService adminCacheService;

    @Override
    public List<UmsAdmin> list() {
        return adminMapper.selectByExample(new UmsAdminExample());
    }

    @Override
    public UmsAdmin getByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if (admin != null) {
            return admin;
        }
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }
}
