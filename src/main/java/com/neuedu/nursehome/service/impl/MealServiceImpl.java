package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.Meal;
import com.neuedu.nursehome.mapper.MealMapper;
import com.neuedu.nursehome.service.MealService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

    @Override
    public List<Meal> getMealsByDate(LocalDate date) {
        QueryWrapper<Meal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meal_date", date);
        return baseMapper.selectList(queryWrapper);
    }
}