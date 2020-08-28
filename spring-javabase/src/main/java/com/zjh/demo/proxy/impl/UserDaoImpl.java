package com.zjh.demo.proxy.impl;

import com.zjh.demo.domain.User;
import com.zjh.demo.proxy.IUserDao;

public class UserDaoImpl implements IUserDao {
    public User findAll() {
        User user = new User();
        user.setName("zhuojianhai");
        user.setAge(31);
        user.setAddress("中国江苏省徐州市睢宁县");
        System.out.println(user.toString());
        return user;
    }
}
