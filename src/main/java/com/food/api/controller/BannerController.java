package com.food.api.controller;

import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.BannerDTO;
import com.food.api.service.BannerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
* @description: 粽子分类对外接口层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController<BannerService, BannerDTO> {


    @Override
    @Resource(name = "bannerService")
    protected void setBaseService(BannerService bannerService) {
        this.baseService = bannerService;
    }

    /**
    * 默认分页查询
    * @param bannerDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.basePage(bannerDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param bannerDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.findList(bannerDTO));
    }

    @Override
    protected void beforeSave(BannerDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

