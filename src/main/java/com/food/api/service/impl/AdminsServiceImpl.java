package com.food.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.food.api.dao.AdminsDao;
import com.food.api.dto.AdminsDTO;
import com.food.api.dto.DataDTO;
import com.food.api.service.AdminsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 管理员业务层实现类
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Service("adminsService")
public class AdminsServiceImpl extends ServiceImpl<AdminsDao, AdminsDTO> implements AdminsService {

    @Override
    public Page<AdminsDTO> basePage(AdminsDTO adminsDTO) {
        if (null != adminsDTO.getCurrent() && null != adminsDTO.getPageSize())
            adminsDTO.setCurrent((adminsDTO.getCurrent() - 1) * adminsDTO.getPageSize());
        List<AdminsDTO> list = this.baseMapper.findList(adminsDTO);
        int count = this.baseMapper.findPageCount(adminsDTO);
        Page<AdminsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<AdminsDTO> findList(AdminsDTO adminsDTO) {
        return this.baseMapper.findList(adminsDTO);
    }

    @Override
    public List<DataDTO> getOrderTotalDay(Integer day) {
        return this.baseMapper.getOrderTotalDay(day);
    }

    @Override
    public List<DataDTO> typeCount() {
        return this.baseMapper.typeCount();
    }

    @Override
    public List<DataDTO> typeMoney() {
        return this.baseMapper.typeMoney();

    }

}
