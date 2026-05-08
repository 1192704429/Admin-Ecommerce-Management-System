package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity. Users;
import lombok.Data;
import lombok.ToString;

/**
* @description: 用户表数据传输层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@ToString
@TableName("users")
public class UsersDTO extends Users {


}
