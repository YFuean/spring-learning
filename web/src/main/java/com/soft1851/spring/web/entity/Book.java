package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Book
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String name;
    private Double price;
}
