package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.FoodCommentDao;
import com.food.api.dto.FoodCommentDTO;
import com.food.api.service.FoodCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 粽子评价管理业务层实现类
* @author: food
* @create: 2023.10.07 15:27:22
*/
@Service("foodCommentService")
public class FoodCommentServiceImpl extends ServiceImpl<FoodCommentDao, FoodCommentDTO> implements FoodCommentService {

    @Override
    public Page<FoodCommentDTO> basePage(FoodCommentDTO foodCommentDTO) {
        if (null != foodCommentDTO.getCurrent() && null != foodCommentDTO.getPageSize())
            foodCommentDTO.setCurrent((foodCommentDTO.getCurrent() - 1) * foodCommentDTO.getPageSize());
        List<FoodCommentDTO> list = this.baseMapper.findList(foodCommentDTO);
        int count = this.baseMapper.findPageCount(foodCommentDTO);
        Page<FoodCommentDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<FoodCommentDTO> findList(FoodCommentDTO foodCommentDTO) {
        return this.baseMapper.findList(foodCommentDTO);
    }

}
