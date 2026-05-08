package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity. OrderDetail;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 订单详情数据传输层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@ToString
@TableName("order_detail")
public class OrderDetailDTO extends OrderDetail {

    /**
    * 订单编号
    */
    @TableField(exist = false)
    private String orderNo;
    /**
    * 粽子名称
    */
    @TableField(exist = false)
    private String dishName;
    /**
    * 粽子图片
    */
    @TableField(exist = false)
    private String dishImg;

}
