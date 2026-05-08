package com.food.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.food.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
* @description: 粽子分类实体类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Banner extends BaseEntity {

    /**
    * 分类编号
    */
    private Long id;
    /**
    * 分类名称
    */
    private String bannerImg;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
