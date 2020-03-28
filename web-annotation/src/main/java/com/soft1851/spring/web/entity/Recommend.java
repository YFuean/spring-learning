package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Recommend
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommend {
    private String id;
    private String userName;
    private String avatar;
    private String cityName;
    private String professionName;
    private Integer contentCount;
    private Integer popularityCount;
    private Integer fansCount;
}
