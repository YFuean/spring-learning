package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @ClassName TeacherMapper
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/31
 **/
public interface TeacherMapper {
    /**
     * 根据teacherId一对一
     * @param teacherId
     * @return
     */
    Teacher getTeacherOneToOne(int teacherId);
}
