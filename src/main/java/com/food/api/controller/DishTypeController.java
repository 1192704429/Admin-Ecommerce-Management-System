package com.food.api.controller;

import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.DishTypeDTO;
import com.food.api.service.DishTypeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.food.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 粽子分类对外接口层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@RestController
@RequestMapping("/dishType")
public class DishTypeController extends BaseController<DishTypeService, DishTypeDTO> {


    @Override
    @Resource(name = "dishTypeService")
    protected void setBaseService(DishTypeService dishTypeService) {
        this.baseService = dishTypeService;
    }

    /**
    * 默认分页查询
    * @param dishTypeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody DishTypeDTO dishTypeDTO) {
        return ReturnMsg.ok(baseService.basePage(dishTypeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param dishTypeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody DishTypeDTO dishTypeDTO) {
        return ReturnMsg.ok(baseService.findList(dishTypeDTO));
    }

    @Override
    protected void beforeSave(DishTypeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

