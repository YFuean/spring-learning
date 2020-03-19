package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.config.JdbcConfig;
import com.soft1851.spring.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ForumDaoTest
 * @Description 注解配置版
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
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