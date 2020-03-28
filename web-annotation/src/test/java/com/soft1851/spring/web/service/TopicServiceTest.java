package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.JdbcConfig;
import com.soft1851.spring.web.spider.JueJinSpider;
import com.soft1851.spring.web.spider.ZCOOLSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  {JdbcConfig.class})
public class TopicServiceTest {
    @Autowired
    private TopicService topicService;
    @Test
    public void queryAll() {
        System.out.println(topicService.queryAll());
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopic());
        assertEquals(JueJinSpider.getTopic().size(),ints.length);
    }
}