package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName AppConfig
 * @Description 注解配置
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@Configuration
public class AppConfig {

    /**
     * 学生和手机
     * @return
     */
    @Bean
    public Phone phone(){
        Phone phone = new Phone();
        phone.setBrand("iPhone11");
        phone.setPrice(12232.0);
        return phone;
    }
    @Bean
    public Phone phone1(){
        Phone phone1 = new Phone();
        phone1.setBrand("iPhone8");
        phone1.setPrice(5333.0);
        return phone1;
    }
    @Bean
    public Student student(){
        Student student = new Student();
        student.setName("岳凡");
        student.setPhone(phone());
        return  student;
    }
    /**
     * 用户登录
     */
    @Bean
    public User user(){
        User user = new User();
        user.setAccount("admin");
        user.setPassword("111");
        return user;
    }
    @Bean
    public  UserLogin userLogin(User user){
        return new UserLogin(user);
    }

    /**
     * 书
     * @return
     */
    @Bean
    public Book book(){
        return new Book();
    }
    @Bean
    public Book book1(){
        Book book1 = new Book();
        book1.setName("java");
        book1.setPrice(123.2);
        return book1;
    }
    @Bean
    public Book book2(){
        Book book2 = new Book();
        book2.setName("IOS");
        book2.setPrice(233.2);
        return book2;
    }

    /**
     * NewStudent类装配list phone,map scores,set book
     */
    @Bean
    public NewStudent newStudent(){
        return new NewStudent();
    }
}
