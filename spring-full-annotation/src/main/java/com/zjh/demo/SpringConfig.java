package com.zjh.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.zjh.demo.mapper.UserMapper2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * 相当于 spring.xml 文件,
 * 替换掉xml文件，使用注解
 */
@Configuration
@ComponentScan(basePackages = {"com.zjh.demo"})
//数据可配置文件
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String jdbc_driver;

    @Value("${jdbc.url}")
    private String jdbc_url;

    @Value("${jdbc.username}")
    private String jdbc_username;

    @Value("${jdbc.password}")
    private String jdbc_password;

    /**
     * bean id：方法名称
     * 默认是单例
     * @return
     */
    @Bean
    public UserMapper2 userMapper2(){
        return  new UserMapper2();
    }

    @Bean(value = "userMapper3")
    @Scope("prototype")
    public UserMapper2 userMapper3(){
        return  new UserMapper2();
    }



    /**alibaba 连接池
     * 将jdbc.properties配置文件改成java配置
     * */

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbc_driver);
        dataSource.setUrl(jdbc_url);
        dataSource.setUsername(jdbc_username);
        dataSource.setPassword(jdbc_password);
        return dataSource;

    }
}
