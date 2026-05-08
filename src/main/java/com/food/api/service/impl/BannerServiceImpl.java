package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.BannerDao;
import com.food.api.dto.BannerDTO;
import com.food.api.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 粽子分类业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerDTO> implements BannerService {

    @Override
    public Page<BannerDTO> basePage(BannerDTO dishTypeDTO) {
        if (null != dishTypeDTO.getCurrent() && null != dishTypeDTO.getPageSize())
            dishTypeDTO.setCurrent((dishTypeDTO.getCurrent() - 1) * dishTypeDTO.getPageSize());
        List<BannerDTO> list = this.baseMapper.findList(dishTypeDTO);
        int count = this.baseMapper.findPageCount(dishTypeDTO);
        Page<BannerDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BannerDTO> findList(BannerDTO dishTypeDTO) {
        return this.baseMapper.findList(dishTypeDTO);
    }

}
