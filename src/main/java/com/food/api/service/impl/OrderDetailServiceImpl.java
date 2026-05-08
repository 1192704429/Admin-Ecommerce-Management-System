package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.OrderDetailDao;
import com.food.api.dto.OrderDetailDTO;
import com.food.api.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 订单详情业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetailDTO> implements OrderDetailService {

    @Override
    public Page<OrderDetailDTO> basePage(OrderDetailDTO orderDetailDTO) {
        if (null != orderDetailDTO.getCurrent() && null != orderDetailDTO.getPageSize())
            orderDetailDTO.setCurrent((orderDetailDTO.getCurrent() - 1) * orderDetailDTO.getPageSize());
        List<OrderDetailDTO> list = this.baseMapper.findList(orderDetailDTO);
        int count = this.baseMapper.findPageCount(orderDetailDTO);
        Page<OrderDetailDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<OrderDetailDTO> findList(OrderDetailDTO orderDetailDTO) {
        return this.baseMapper.findList(orderDetailDTO);
    }

}
