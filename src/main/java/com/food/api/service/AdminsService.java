package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.AdminsDTO;
import com.food.api.dto.DataDTO;

import java.util.List;
/**
* @description: 管理员业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface AdminsService extends IService<AdminsDTO> {

    /**
    * 默认分页方法
    * @param adminsDTO
    * @return
    */
    Page<AdminsDTO> basePage(AdminsDTO adminsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param adminsDTO
    * @return
    */
    List<AdminsDTO> findList(AdminsDTO adminsDTO);

    List<DataDTO> getOrderTotalDay(Integer day);

    List<DataDTO> typeCount();

    List<DataDTO> typeMoney();
}
