package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.DishDTO;
import java.util.List;
/**
* @description: 粽子业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface DishService extends IService<DishDTO> {

    /**
    * 默认分页方法
    * @param dishDTO
    * @return
    */
    Page<DishDTO> basePage(DishDTO dishDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param dishDTO
    * @return
    */
    List<DishDTO> findList(DishDTO dishDTO);

}
