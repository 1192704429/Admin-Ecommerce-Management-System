package com.food.api.entity;

import com.food.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 订单详情实体类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail extends BaseEntity {

    /**
    * 订单详情
    */
    private Long id;
    /**
    * 订单编号
    */
    private Long orderId;
    /**
    * 粽子编号
    */
    private Long dishId;
    /**
    * 单价
    */
    private String dishPrice;
    /**
    * 数量
    */
    private Integer num;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
