package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @ClassName CourseMapper
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/31
 **/
public interface CourseMapper {
    Course getCourseById(int courseId);
}
