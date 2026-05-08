package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity. Orders;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 订单管理数据传输层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@ToString
@TableName("orders")
public class OrdersDTO extends Orders {

    /**
    * 用户昵称
    */
    @TableField(exist = false)
    private String nickName;


    @TableField(exist = false)
    List<OrderDetailDTO> orderDetailDTOS;

}
