package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Recommend;

import java.util.List;

/**
 * @ClassName RecommendDao
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
public interface RecommendDao {
    List<Recommend> selectAll();

    int insert(Recommend recommend);

    int[] batchInsert(List<Recommend> recommends);
}
