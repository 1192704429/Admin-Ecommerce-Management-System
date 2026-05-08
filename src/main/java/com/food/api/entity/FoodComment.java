package com.food.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.food.api.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
* @description: 粽子评价管理实体类
* @author: food
* @create: 2023.10.07 15:27:22
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodComment extends BaseEntity {

    /**
    * 评论编号
    */
    private Long id;
    /**
    * 评价内容
    */
    private String commentInfo;

    /**
    * 用户ID
    */
    private Long userId;
    private Long parentId;
    private Long toUserId;
    /**
    * 粽子ID
    */
    private Long foodsId;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
