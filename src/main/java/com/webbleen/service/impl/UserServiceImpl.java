package com.webbleen.service.impl;

import com.webbleen.entity.User;
import com.webbleen.mapper.UserMapper;
import com.webbleen.service.UserService;
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
