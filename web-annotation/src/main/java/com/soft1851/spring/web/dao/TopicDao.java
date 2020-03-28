package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @ClassName TopicDao
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/26
 **/
public interface TopicDao {
    List<Topic> selectAll();

    int insert(Topic topic);

    int[] batchInsert(List<Topic> topics);

}
