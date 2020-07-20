package com.webbleen.ssm.service.impl;

import com.webbleen.ssm.entity.User;
import com.webbleen.ssm.mapper.UserMapper;
import com.webbleen.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
