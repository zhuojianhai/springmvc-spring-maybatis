package com.zjh.demo.dao;

import com.zjh.demo.domain.User;

import java.util.List;

/**
 * 用户持久成接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
     List<User> findAll();
}
