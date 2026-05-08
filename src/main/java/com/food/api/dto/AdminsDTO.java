package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity. Admins;
import lombok.Data;
import lombok.ToString;

/**
* @description: 管理员数据传输层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@ToString
@TableName("admins")
public class AdminsDTO extends Admins {


}
