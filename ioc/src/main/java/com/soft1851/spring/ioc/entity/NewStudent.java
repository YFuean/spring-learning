package com.soft1851.spring.ioc.entity;

import java.util.List;

/**
 * @ClassName Stu
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/
public class NewStudent {
    private Integer id;
    private String name;
    private List<Phone> phones;

    public NewStudent(Integer id, String name, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.phones = phones;
    }

    public NewStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
