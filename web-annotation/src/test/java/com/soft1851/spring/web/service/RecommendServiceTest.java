package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.JdbcConfig;
import com.soft1851.spring.web.spider.ZCOOLSpider;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  {JdbcConfig.class})
public class RecommendServiceTest {
    @Autowired
    private RecommendService recommendService;
    @Test
    public void queryAll() {
        System.out.println(recommendService.queryAll());
    }

    @Test
    public void batchInsert() {
        int[] ints = new int[0];
        try {
            ints = recommendService.batchInsert(ZCOOLSpider.getRecommend());
            assertEquals(ZCOOLSpider.getRecommend().size(),ints.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}