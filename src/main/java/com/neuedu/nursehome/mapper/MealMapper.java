package com.neuedu.nursehome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.nursehome.entity.Meal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealMapper extends BaseMapper<Meal> {
}