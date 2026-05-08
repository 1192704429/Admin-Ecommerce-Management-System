package com.food.api.controller;

import com.alipay.api.domain.UserDTO;
import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.AdminsDTO;
import com.food.api.dto.DataDTO;
import com.food.api.service.AdminsService;
import com.food.api.service.OrdersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.food.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;

import java.util.Date;

/**
 * @description: 管理员对外接口层
 * @author: xican
 * @create: 2025.01.18 17:43:15
 */
@RestController
@RequestMapping("/admins")
public class AdminsController extends BaseController<AdminsService, AdminsDTO> {


    @Autowired
    private OrdersService ordersService;

    @Override
    @Resource(name = "adminsService")
    protected void setBaseService(AdminsService adminsService) {
        this.baseService = adminsService;
    }

    /**
     * 默认分页查询
     *
     * @param adminsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody AdminsDTO adminsDTO) {
        return ReturnMsg.ok(baseService.basePage(adminsDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param adminsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody AdminsDTO adminsDTO) {
        return ReturnMsg.ok(baseService.findList(adminsDTO));
    }

    @Override
    protected void beforeSave(AdminsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }



    @GetMapping("/echarts/{day}")
    public ReturnMsg echarts(@PathVariable Integer day) {
        // 最近几天营业额
        List<DataDTO> totalMoney = this.baseService.getOrderTotalDay(day);
        // 不同分类下面的产品数量
        List<DataDTO> typeCount = this.baseService.typeCount();
        // 不同分类的营业额
        List<DataDTO> typeMoney = this.baseService.typeMoney();
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalMoney", totalMoney);
        map.put("typeCount", typeCount);
        map.put("typeMoney", typeMoney);
        return ReturnMsg.ok(map);
    }

}

