package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.OrdersDTO;
import java.util.List;
/**
* @description: 订单管理业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface OrdersService extends IService<OrdersDTO> {

    /**
    * 默认分页方法
    * @param ordersDTO
    * @return
    */
    Page<OrdersDTO> basePage(OrdersDTO ordersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param ordersDTO
    * @return
    */
    List<OrdersDTO> findList(OrdersDTO ordersDTO);

}
