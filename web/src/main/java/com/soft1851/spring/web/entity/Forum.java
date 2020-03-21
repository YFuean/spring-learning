package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Forum
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum implements Serializable {
    private Integer forumId;
    private String forumName;
}
