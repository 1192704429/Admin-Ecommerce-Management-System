package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.UsersDTO;
import java.util.List;
/**
* @description: 用户表业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface UsersService extends IService<UsersDTO> {

    /**
    * 默认分页方法
    * @param usersDTO
    * @return
    */
    Page<UsersDTO> basePage(UsersDTO usersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param usersDTO
    * @return
    */
    List<UsersDTO> findList(UsersDTO usersDTO);

}
