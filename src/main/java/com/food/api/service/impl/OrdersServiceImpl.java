package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.OrdersDao;
import com.food.api.dto.OrdersDTO;
import com.food.api.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 订单管理业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersDTO> implements OrdersService {

    @Override
    public Page<OrdersDTO> basePage(OrdersDTO ordersDTO) {
        if (null != ordersDTO.getCurrent() && null != ordersDTO.getPageSize())
            ordersDTO.setCurrent((ordersDTO.getCurrent() - 1) * ordersDTO.getPageSize());
        List<OrdersDTO> list = this.baseMapper.findList(ordersDTO);
        int count = this.baseMapper.findPageCount(ordersDTO);
        Page<OrdersDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<OrdersDTO> findList(OrdersDTO ordersDTO) {
        return this.baseMapper.findList(ordersDTO);
    }

}
