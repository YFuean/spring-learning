package com.soft1851.spring.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class UserLoginTest {
    @Autowired
    private UserLogin login1,login2;
    @Test
    public void test(){
        login1.userLogin(login1.getUser());
        login2.userLogin(login2.getUser());
    }
}