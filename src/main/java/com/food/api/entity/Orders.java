package com.food.api.entity;

import com.food.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 订单管理实体类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders extends BaseEntity {

    /**
    * 系统编号
    */
    private Long id;
    /**
    * 订单编号
    */
    private String orderNo;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 总价
    */
    private String totalPrice;
    /**
    * 收货地址
    */
    private String address;
    /**
    * 联系方式
    */
    private String phone;
    /**
    * 订单类型
    */
    private Integer orderType;


    /**
    * 订单状态
    */
    private Integer orderStatus;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 备注
    */
    private String remark;


    /**
    * 用户评论
    */
    private String comment;
    /**
    * 商家回复
    */
    private String reply;


}
