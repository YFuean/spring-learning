package com.soft1851.spring.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AppConfig
 * @Description xml配置的测试
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"/beans.xml"})
public class BookTest {
    @Autowired
    private Book book;
    @Test
    public void test(){
        System.out.println(book);
    }
}