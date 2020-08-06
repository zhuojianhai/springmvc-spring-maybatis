package com.zjh.demo.mapper;

import com.zjh.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userMapper")
public class UserMapper {
    public User findById(String id){

        //模拟数据库查询
        User user = new User();

        user.setId(id);
        user.setName("张三");

        return user;
    }
}
