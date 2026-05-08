package com.food.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.food.api.dto.BannerDTO;

import java.util.List;

/**
* @description: 粽子分类业务层接口
* @author: xican
* @create: 2025.01.18 17:43:15
*/
public interface BannerService extends IService<BannerDTO> {

    /**
    * 默认分页方法
    * @param dishTypeDTO
    * @return
    */
    Page<BannerDTO> basePage(BannerDTO dishTypeDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param dishTypeDTO
    * @return
    */
    List<BannerDTO> findList(BannerDTO dishTypeDTO);

}
