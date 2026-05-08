package com.food.api.entity;

import com.food.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 粽子实体类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dish extends BaseEntity {

    /**
    * 粽子编号
    */
    private Long id;
    /**
    * 粽子名称
    */
    private String dishName;
    /**
    * 粽子图片
    */
    private String dishImg;
    /**
    * 粽子简介
    */
    private String dishInfo;
    /**
    * 口味
    */
    private String taste;
    /**
    * 价格
    */
    private String price;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 状态
    */
    private Integer status;
    private Integer stock;
    /**
    * 所属分类
    */
    private Long typeId;


}
