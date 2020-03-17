package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @ClassName PostDao
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/
public interface PostDao {
    /**
     *新增
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     *批量新增
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);

    /**
     *删除
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     *批量删除
     * @param postIds
     * @return
     */
    int[] batchDelete(List<Integer> postIds);

    /**
     *根据id查找
     * @param postId
     * @return
     */
    Post getById(int postId);

    /**
     *根据关键词查找
     * @param keywords
     * @return
     */
    List<Post> getByKeywords(String keywords);

    /**
     * 统计某个论坛的帖子总数
     * @param forumId
     * @return
     */
    int countByForumId(int forumId);
}
