package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.vo.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ClazzMapper
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/31
 **/
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {
    /**
     * 获取指定班级中所有学生信息
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    List<Map<String,Object>> getClazzStudentMap(int id);

    /**
     * 根据clazzId一对多联查本班所有学生
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);
}
