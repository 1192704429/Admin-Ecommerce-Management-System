package com.food.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.FoodCommentDTO;
import com.food.api.service.FoodCommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @description: 粽子评价管理对外接口层
* @author: food
* @create: 2023.10.07 15:27:22
*/
@RestController
@RequestMapping("/foodComment")
public class FoodCommentController extends BaseController<FoodCommentService, FoodCommentDTO> {


    @Override
    @Resource(name = "foodCommentService")
    protected void setBaseService(FoodCommentService foodCommentService) {
        this.baseService = foodCommentService;
    }

    /**
    * 默认分页查询
    * @param foodCommentDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody FoodCommentDTO foodCommentDTO) {
        return ReturnMsg.ok(baseService.basePage(foodCommentDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param foodCommentDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody FoodCommentDTO foodCommentDTO) {
        return ReturnMsg.ok(baseService.findList(foodCommentDTO));
    }

    @Override
    protected void beforeSave(FoodCommentDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/allComments")
    public ReturnMsg allComments(@RequestBody FoodCommentDTO commentsDTO) {
        List<FoodCommentDTO> baseServiceList = baseService.findList(commentsDTO);
        if (CollectionUtil.isNotEmpty(baseServiceList)) {
            for (FoodCommentDTO dto : baseServiceList) {
                FoodCommentDTO query = new FoodCommentDTO();
                query.setParentId(dto.getId());
                dto.setFoodCommentDTOList(this.baseService.findList(query));
            }
        }
        return ReturnMsg.ok(baseServiceList);
    }

}

