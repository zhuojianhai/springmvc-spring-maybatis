package com.zjh.demo.service.impl;

import com.zjh.demo.entity.User;
import com.zjh.demo.mapper.UserMapper;
import com.zjh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层---->dao层（mapper）
 * 得到数据
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(String id) {
        return userMapper.findById(id);
    }
}
