package com.zjh.demo.test;

import com.zjh.demo.proxy.IUserDao;
import com.zjh.demo.proxy.UserDaoHandler;
import com.zjh.demo.proxy.impl.UserDaoImpl;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {


        testProxy();

    }

    /**
     * 测试基于接口的动态代理
     */
    private static void testProxy(){
        UserDaoHandler daoHandler = new UserDaoHandler();
        try {
            IUserDao userDao1 = (IUserDao) daoHandler.getProxyInstanceObj(UserDaoImpl.class);
            userDao1.findAll();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void show(){
        try {
            Class<?> clazz = Class.forName(Test.class.getCanonicalName());
            Method method = clazz.getDeclaredMethod("testProxy",null);
            method.setAccessible(true);
            method.invoke(clazz.newInstance(),null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
