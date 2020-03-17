package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;

import java.util.List;

/**
 * @ClassName FormDao
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/
public interface ForumDao {
    /**
     * 新增Forum
     * @param forum
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量增加Forum
     * @param forums
     * @return int[]
     */
     int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Forum
     * @param forumId
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改Forum
     * @param forum
     * @return int
     */
    int update(Forum forum);

    /**
     * 根据id查询Forum
     * @param forumId
     * @return Forum
     */
    Forum getById(int forumId);

    /**
     * 查询所有论坛信息
     * @return List<Forum>
     */
    List<Forum> selectAll();
}
