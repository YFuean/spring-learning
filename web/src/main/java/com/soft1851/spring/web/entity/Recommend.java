package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Recommend
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommend {
    private String title;
    private String type;
    private Integer visit;
    private Integer comment;
    private Integer flower;
    private String author;
    private String time;
    private String img;
    private String avatar;
}
