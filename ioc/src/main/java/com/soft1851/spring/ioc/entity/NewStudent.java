package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Stu
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewStudent {
    private Integer id;
    private String name;
    private List<Phone> phones;
    private Map scores;
    private Set<Book> books;
}
