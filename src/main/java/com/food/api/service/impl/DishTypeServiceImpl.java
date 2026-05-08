package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.DishTypeDao;
import com.food.api.dto.DishTypeDTO;
import com.food.api.service.DishTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 粽子分类业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("dishTypeService")
public class DishTypeServiceImpl extends ServiceImpl<DishTypeDao, DishTypeDTO> implements DishTypeService {

    @Override
    public Page<DishTypeDTO> basePage(DishTypeDTO dishTypeDTO) {
        if (null != dishTypeDTO.getCurrent() && null != dishTypeDTO.getPageSize())
            dishTypeDTO.setCurrent((dishTypeDTO.getCurrent() - 1) * dishTypeDTO.getPageSize());
        List<DishTypeDTO> list = this.baseMapper.findList(dishTypeDTO);
        int count = this.baseMapper.findPageCount(dishTypeDTO);
        Page<DishTypeDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<DishTypeDTO> findList(DishTypeDTO dishTypeDTO) {
        return this.baseMapper.findList(dishTypeDTO);
    }

}
