package com.webbleen.ssm.service;

import com.webbleen.ssm.entity.UmsAdmin;

public interface AdminCacheService {

    void setAdmin(UmsAdmin admin);

    UmsAdmin getAdmin(String username);

    void delAdmin(Long adminId);
}
