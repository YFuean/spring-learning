package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.RecommendDao;
import com.soft1851.spring.web.entity.Recommend;
import com.soft1851.spring.web.service.RecommendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RecommendServiceImpl
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class RecommendServiceImpl implements RecommendService {
    @Resource
    private RecommendDao recommendDao;

    @Override
    public List<Recommend> queryAll() {
        return recommendDao.selectAll();
    }

    @Override
    public void addTopic(Recommend recommend) {
        recommendDao.insert(recommend);
        try{
            int a = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int[] batchInsert(List<Recommend> recommends) {
        return recommendDao.batchInsert(recommends);
    }
}
