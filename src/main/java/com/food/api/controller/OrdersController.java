package com.food.api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.*;
import com.food.api.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.food.api.common.BaseSelectEntity;

import java.util.ArrayList;

import javax.annotation.Resource;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.food.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;

import java.util.Date;

/**
 * @description: 订单管理对外接口层
 * @author: xican
 * @create: 2025.01.18 17:43:15
 */
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<OrdersService, OrdersDTO> {

    @Autowired
    private UsersService usersService;
    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    @Resource(name = "ordersService")
    protected void setBaseService(OrdersService ordersService) {
        this.baseService = ordersService;
    }

    /**
     * 默认分页查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrdersDTO ordersDTO) {
        Page<OrdersDTO> ordersDTOPage = baseService.basePage(ordersDTO);
        List<OrdersDTO> pageRecords = ordersDTOPage.getRecords();
        if (CollectionUtil.isNotEmpty(pageRecords)) {
            for (OrdersDTO pageRecord : pageRecords) {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                orderDetailDTO.setOrderId(pageRecord.getId());
                pageRecord.setOrderDetailDTOS(orderDetailService.findList(orderDetailDTO));
            }
        }
        return ReturnMsg.ok(ordersDTOPage);
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.findList(ordersDTO));
    }

    @Override
    protected void beforeSave(OrdersDTO entity) throws Exception {
        entity.setOrderNo(System.currentTimeMillis() / 1000 + "");
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/updateOrder")
    public ReturnMsg updateOrder(@RequestBody OrdersDTO ordersDTO) {
        baseService.updateById(ordersDTO);
        return ReturnMsg.ok();
    }

    @GetMapping("/all/users")
    public ReturnMsg allUsers() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<UsersDTO> dtos = usersService.list();
        for (UsersDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNickName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

