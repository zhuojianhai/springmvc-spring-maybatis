package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zjh.demo.SpringConfig;
import com.zjh.demo.entity.User;
import com.zjh.demo.mapper.UserMapper2;
import com.zjh.demo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserServiceTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] strs = applicationContext.getBeanDefinitionNames();
        for (String name:strs){
            System.out.println(name);
        }

        /**
         * 执行结果
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.annotation.internalRequiredAnnotationProcessor
         * org.springframework.context.annotation.internalCommonAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         * springConfig
         * userMapper
         * userServiceImpl
         */
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
      UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
      User user =  userService.selectById("100");
        System.out.println(user);


    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        User user =  userService.selectById("100");
        System.out.println(user);

        UserMapper2 userMapper2 = (UserMapper2) applicationContext.getBean("userMapper3");
        UserMapper2 userMapper3 = (UserMapper2) applicationContext.getBean("userMapper3");
        System.out.println("userMapper2 == userMapper3 "+(userMapper2 == userMapper3)+"");


    }

    @Test
    public void test4() throws SQLException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DruidDataSource dataSource = applicationContext.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());


    }
}
