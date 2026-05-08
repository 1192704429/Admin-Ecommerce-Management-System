package com.food.api.controller;

import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.OrderDetailDTO;
import com.food.api.service.OrderDetailService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.food.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.food.api.service.OrdersService;
import com.food.api.dto.OrdersDTO;
import com.food.api.service.DishService;
import com.food.api.dto.DishDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.food.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 订单详情对外接口层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController extends BaseController<OrderDetailService, OrderDetailDTO> {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private DishService dishService;

    @Override
    @Resource(name = "orderDetailService")
    protected void setBaseService(OrderDetailService orderDetailService) {
        this.baseService = orderDetailService;
    }

    /**
    * 默认分页查询
    * @param orderDetailDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ReturnMsg.ok(baseService.basePage(orderDetailDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param orderDetailDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ReturnMsg.ok(baseService.findList(orderDetailDTO));
    }

    @Override
    protected void beforeSave(OrderDetailDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/orders")
    public ReturnMsg allOrders() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<OrdersDTO> dtos = ordersService.list();
            for (OrdersDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getOrderNo());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/dish")
    public ReturnMsg allDish() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<DishDTO> dtos = dishService.list();
            for (DishDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getDishName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

