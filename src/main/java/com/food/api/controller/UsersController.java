package com.food.api.controller;

import com.food.api.common.BaseController;
import com.food.api.common.ReturnMsg;
import com.food.api.dto.UsersDTO;
import com.food.api.service.UsersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.food.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 用户表对外接口层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@RestController
@RequestMapping("/users")
public class UsersController extends BaseController<UsersService, UsersDTO> {


    @Override
    @Resource(name = "usersService")
    protected void setBaseService(UsersService usersService) {
        this.baseService = usersService;
    }

    /**
    * 默认分页查询
    * @param usersDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody UsersDTO usersDTO) {
        return ReturnMsg.ok(baseService.basePage(usersDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param usersDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody UsersDTO usersDTO) {
        return ReturnMsg.ok(baseService.findList(usersDTO));
    }

    @Override
    protected void beforeSave(UsersDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }



    @PostMapping(value = "/login")
    public ReturnMsg login(@RequestBody UsersDTO usersDTO) throws Exception {
        List<UsersDTO> list = baseService.findList(usersDTO);
        if (CollectionUtil.isEmpty(list)) throw new Exception("账号或密码有误");
        return ReturnMsg.ok(list.get(0));
    }

    @PostMapping(value = "/register")
    public ReturnMsg register(@RequestBody UsersDTO usersDTO) throws Exception {
        UsersDTO usersDTO1 = new UsersDTO();
        usersDTO1.setUserName(usersDTO.getUserName());
        List<UsersDTO> list = baseService.findList(usersDTO1);
        if (CollectionUtil.isNotEmpty(list)) throw new Exception("账号已被占用");
        usersDTO.setNickName("客户-" + usersDTO.getUserName());
        usersDTO.setCreateTime(new Date());
        usersDTO.setHeadImg("https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2022-05-09/f2623747-22cd-4faa-8c37-bf53f88fe34d_2.png");
        this.baseService.save(usersDTO);
        return ReturnMsg.ok();
    }

}

