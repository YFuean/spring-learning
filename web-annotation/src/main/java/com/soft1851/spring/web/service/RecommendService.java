package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Recommend;

import java.util.List;

/**
 * @ClassName RecommendService
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
public interface RecommendService {
    List<Recommend> queryAll();
    void addTopic(Recommend recommend);
    int[] batchInsert(List<Recommend> recommends);
}
