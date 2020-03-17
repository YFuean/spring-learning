package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.Location;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class ForumDaoTest {
    @Autowired
    private ForumDao forumDao;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("共抗疫情").build();
        forumDao.insert(forum);
    }

    @Test
    public void delete() {
        forumDao.delete(9);
    }

    @Test
    public void update() {
        Forum forum = Forum.builder().forumName("测试").forumId(8).build();
        forumDao.update(forum);
    }

    @Test
    public void batchInsert() {
        String[] titles = {"搞笑视频","一起来吐槽","聊天套路"};
        List<Forum> forumList = new ArrayList<>();
        for (int i = 0;i<titles.length;i++){
            Forum forum = Forum.builder().forumName(titles[i]).build();
            forumList.add(forum);
        }
        forumDao.batchInsert(forumList);
    }

    @Test
    public void getById() {
        Forum forum = forumDao.getById(3);
        System.out.println(forum);
    }

    @Test
    public void selectAll() {
        List<Forum> forumList = forumDao.selectAll();
        for (Forum forum:forumList) {
            System.out.println(forum);
        }
    }
}