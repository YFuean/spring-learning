package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试1")
                .hometown("江苏常州")
                .birthday(LocalDate.of(2000,03,23))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(2010);
    }

    @Test
    public void update() {
        Student student = Student.builder()
                .studentId(2011)
                .clazzId(2)
                .studentName("测试22")
                .hometown("江苏徐州")
                .birthday(LocalDate.of(2000,11,11))
                .build();
        studentMapper.update(student);
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for(int i = 0 ;i <10;i++){
            Student student = Student.builder()
                    .studentName("测试" + i)
                    .clazzId(2)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(2000,01,01))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i = 2012; i< 2022;i++){
            idList.add(i);
        }
        System.out.println(studentMapper.batchDelete(idList));
    }

    @Test
    public void selectLimit() {
        List<Student> students = studentMapper.selectLimit();
        for (Student student: students) {
            System.out.println(student);
        }
    }

    @Test
    public void getStudentById() {
        Student student = studentMapper.getStudentById(1001);
        System.out.println(student);
    }

    @Test
    public void batchUpdate() {
        List<Student> list = new ArrayList<>();
        for(int i = 2022;i<2029;i++){
            Student student = Student.builder()
                    .studentId(i)
                    .studentName("new测试"+ i)
                    .build();
            list.add(student);
        }
        System.out.println(studentMapper.batchUpdate(list));
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder()
                .studentName("汪峰")
                .clazzId(1)
                .hometown("江苏徐州")
                .build();
        System.out.println(studentMapper.selectLimitByDynamicSql(student));
    }

    @Test
    public void selectAll() {
        List<Student> students = studentMapper.selectAll();
        students.forEach(student -> {
            System.out.println(student.getStudentId()+student.getStudentName()+
            student.getHometown()+student.getBirthday()+
                    student.getClazz().getClazzName());
        });
    }
}