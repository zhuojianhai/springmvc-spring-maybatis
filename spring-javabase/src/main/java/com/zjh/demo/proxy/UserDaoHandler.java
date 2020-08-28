package com.zjh.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoHandler implements InvocationHandler {
    //被代理对象
    private Object target;
    public UserDaoHandler(){

    }

    public UserDaoHandler(Object target){
        this.target = target;

    }

    public Object getProxyInstanceObj(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        target = clazz.newInstance();

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method invoke");
         Object result =   method.invoke(target,args);
        System.out.println("after method invoke");
        return result;
    }
}
