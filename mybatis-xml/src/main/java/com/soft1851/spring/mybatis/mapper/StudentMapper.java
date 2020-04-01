package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/31
 **/
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    Student getStudentById(int studentId);
    void insert(Student student);
    void delete(int studentId);
    void update(Student student);
    int batchInsert(@Param("students")List<Student> students);
    int batchDelete(@Param("idList") List<Integer> idList);
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 单表（带两个指定条件）查询
     * @return
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态sql）
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 多对一
     * @return
     */
    List<Student> selectAll();
}
