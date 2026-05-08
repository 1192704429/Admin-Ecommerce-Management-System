package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.DishTypeDTO;
import java.util.List;
/**
* @description: 粽子分类业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface DishTypeService extends IService<DishTypeDTO> {

    /**
    * 默认分页方法
    * @param dishTypeDTO
    * @return
    */
    Page<DishTypeDTO> basePage(DishTypeDTO dishTypeDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param dishTypeDTO
    * @return
    */
    List<DishTypeDTO> findList(DishTypeDTO dishTypeDTO);

}
