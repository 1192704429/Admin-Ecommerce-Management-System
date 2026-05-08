package com.food.api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.food.api.common.BaseController;
import com.food.api.common.BaseSelectEntity;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.DishDTO;
import com.food.api.dto.DishTypeDTO;
import com.food.api.service.DishService;
import com.food.api.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 粽子对外接口层
 * @author: xican
 * @create: 2025.01.18 17:43:15
 */
@RestController
@RequestMapping("/dish")
public class DishController extends BaseController<DishService, DishDTO> {

    @Autowired
    private DishTypeService dishTypeService;

    @Override
    @Resource(name = "dishService")
    protected void setBaseService(DishService dishService) {
        this.baseService = dishService;
    }

    /**
     * 默认分页查询
     *
     * @param dishDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody DishDTO dishDTO) {
        return ReturnMsg.ok(baseService.basePage(dishDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param dishDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody DishDTO dishDTO) {
        return ReturnMsg.ok(baseService.findList(dishDTO));
    }

    @Override
    protected void beforeSave(DishDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/dishType")
    public ReturnMsg allDishType() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<DishTypeDTO> dtos = dishTypeService.list();
        for (DishTypeDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTypeName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    /**
     * 首页热销推荐
     *
     * @param num
     * @return
     */
    @GetMapping("/getIndex/{num}")
    public ReturnMsg getIndex(@PathVariable int num) {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setCurrent(1);
        dishDTO.setPageSize(num);
        dishDTO.setStatus(1);
        Page<DishDTO> dtoPage = this.baseService.basePage(dishDTO);
        return ReturnMsg.ok(dtoPage.getRecords());
    }

}

