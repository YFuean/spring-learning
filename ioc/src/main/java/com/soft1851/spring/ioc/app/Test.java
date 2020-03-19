package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.config.AppConfig;
import com.soft1851.spring.ioc.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @ClassName TestHello
 * @Description 注解配置的测试
 * @Author yue_fan
 * @Date 2020/3/17
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");

        //学生和手机
        Phone phone1 = (Phone) ctx.getBean("phone1");
        System.out.println(phone1);

        Student student = (Student) ctx.getBean("student");
        System.out.println(student);

        //用户登录
        User user = (User) ctx.getBean("user");
        System.out.println(user);

        UserLogin userLogin = (UserLogin) ctx.getBean("userLogin");
        System.out.println(userLogin);

        //图书
        Book book = (Book) ctx.getBean("book");
        book.setName("java");
        book.setPrice(145.2);
        System.out.println(book);

        Book book1 = (Book) ctx.getBean("book1");
        System.out.println(book1);
        Book book2 = (Book) ctx.getBean("book2");
        System.out.println(book2);

        //学生list,set,map
        NewStudent newStudent = (NewStudent) ctx.getBean("newStudent");
        newStudent.setId(1802343301);
        newStudent.setName("大锤");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone1);
        newStudent.setPhones(phoneList);

        Map<String,Integer> scoresMap = new HashMap<>();
        scoresMap.put("javaWeb",88);
        scoresMap.put("软件测试",90);
        scoresMap.put("毛概",76);
        newStudent.setScores(scoresMap);

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        newStudent.setBooks(bookSet);
        System.out.println(newStudent);
    }
}
