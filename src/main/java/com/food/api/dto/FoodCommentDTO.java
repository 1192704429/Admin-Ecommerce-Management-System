package com.food.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.food.api.entity.FoodComment;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description: 粽子评价管理数据传输层
 * @author: food
 * @create: 2023.10.07 15:27:22
 */
@Data
@ToString
@TableName("food_comment")
public class FoodCommentDTO extends FoodComment {

    /**
     * 粽子名称
     */
    @TableField(exist = false)
    private String foodName;
    /**
     * 封面图片
     */
    @TableField(exist = false)
    private String bannerImg;
    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickName;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headImg;

    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String nickNameTo;
    /**
     * 用户头像
     */
    @TableField(exist = false)
    private String headerImgTo;

    @TableField(exist = false)
    private List<FoodCommentDTO> foodCommentDTOList;

}
