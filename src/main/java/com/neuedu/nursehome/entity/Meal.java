package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDate;

@Data
@TableName("meal")
public class Meal {
    @TableId(value = "meal_id", type = IdType.AUTO)
    private Integer mealId;
    private LocalDate mealDate;
    private String mealType; // 枚举值: breakfast, lunch, dinner
    @TableField(value = "introduce", jdbcType = JdbcType.VARCHAR) // 确保识别为字符串
    private String introduce;
    private String image;
}