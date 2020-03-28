package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.JdbcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
public class TopicDaoTest {
    @Autowired
    private TopicDao topicDao;

    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }
}