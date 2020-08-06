package com.zjh.demo.service;

import com.zjh.demo.entity.User;

public interface UserService {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User selectById(String id);
}
