package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.DishDao;
import com.food.api.dto.DishDTO;
import com.food.api.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 粽子业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("dishService")
public class DishServiceImpl extends ServiceImpl<DishDao, DishDTO> implements DishService {

    @Override
    public Page<DishDTO> basePage(DishDTO dishDTO) {
        if (null != dishDTO.getCurrent() && null != dishDTO.getPageSize())
            dishDTO.setCurrent((dishDTO.getCurrent() - 1) * dishDTO.getPageSize());
        List<DishDTO> list = this.baseMapper.findList(dishDTO);
        int count = this.baseMapper.findPageCount(dishDTO);
        Page<DishDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<DishDTO> findList(DishDTO dishDTO) {
        return this.baseMapper.findList(dishDTO);
    }

}
