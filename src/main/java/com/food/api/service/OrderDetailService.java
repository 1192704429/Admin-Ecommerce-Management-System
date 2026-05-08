package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.OrderDetailDTO;
import java.util.List;
/**
* @description: 订单详情业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface OrderDetailService extends IService<OrderDetailDTO> {

    /**
    * 默认分页方法
    * @param orderDetailDTO
    * @return
    */
    Page<OrderDetailDTO> basePage(OrderDetailDTO orderDetailDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param orderDetailDTO
    * @return
    */
    List<OrderDetailDTO> findList(OrderDetailDTO orderDetailDTO);

}
