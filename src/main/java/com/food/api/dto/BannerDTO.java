package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity.Banner;
import com.food.api.entity.DishType;
import lombok.Data;
import lombok.ToString;

/**
* @description: 粽子分类数据传输层
* @author: xican
* @create: 2025.01.18 17:43:15
*/
@Data
@ToString
@TableName("banner")
public class BannerDTO extends Banner {


}
