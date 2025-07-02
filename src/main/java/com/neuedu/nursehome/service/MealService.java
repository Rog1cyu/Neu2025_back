package com.neuedu.nursehome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.nursehome.entity.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealService extends IService<Meal> {

    List<Meal> getMealsByDate(LocalDate date);
}