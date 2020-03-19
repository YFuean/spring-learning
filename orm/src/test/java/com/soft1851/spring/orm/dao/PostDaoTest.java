package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * @ClassName PostDaoTest
 * @Description xml配置版
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insert() {
        byte[] bytes = {2,3,'d','r'};
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        Post post = Post.builder().forumId(3).title("把诗词唱成歌").content("《杨花落尽子规啼》国风诗词怎么能没用我")
                .thumbnail(bytes).createTime(Timestamp.valueOf(time)).build();
        postDao.insert(post);
    }

    @Test
    public void batchInsert() {
        byte[] bytes = {'a',5,'s',6};
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

        Post[] posts = {
                Post.builder().forumId(3).title("把诗词唱成歌").content("《杨花落尽子规啼》国风诗词怎么能没用我")
                        .thumbnail(bytes).createTime(Timestamp.valueOf(time)).build(),
                Post.builder().forumId(3).title("把诗词唱成歌").content("《杨花落尽子规啼》国风诗词怎么能没用我")
                        .thumbnail(bytes).createTime(Timestamp.valueOf(time)).build(),
                Post.builder().forumId(3).title("把诗词唱成歌").content("《杨花落尽子规啼》国风诗词怎么能没用我")
                        .thumbnail(bytes).createTime(Timestamp.valueOf(time)).build()
        };
        List<Post> postList = Arrays.asList(posts);
        postDao.batchInsert(postList);
    }

    @Test
    public void delete() {
        postDao.delete(12);
    }

    @Test
    public void batchDelete() {
        Integer[] ids = {13,14};
        List<Integer> idList = Arrays.asList(ids);
        postDao.batchDelete(idList);
    }

    @Test
    public void getById() {
        Post post = postDao.getById(5);
        System.out.println(post);
    }

    @Test
    public void getByKeywords() {
        List<Post> postList = postDao.getByKeywords("哈");
        for (Post post:postList) {
            System.out.println(post);
        }
    }

    @Test
    public void countByForumId() {
        int num = postDao.countByForumId(2);
        System.out.println(num);
    }
}