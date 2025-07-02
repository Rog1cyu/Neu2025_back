package com.neuedu.nursehome.controller;

import com.neuedu.nursehome.entity.Meal;
import com.neuedu.nursehome.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    /**
     * 根据日期获取膳食信息
     * @param date 日期字符串 (格式: yyyy-MM-dd)
     * @return 当天的所有膳食
     */
    @GetMapping("/{date}")
    public List<Meal> getMealsByDate(@PathVariable String date) {
        LocalDate mealDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return mealService.getMealsByDate(mealDate);
    }

    /**
     * 新增膳食信息
     * @param meal 膳食对象
     * @return 操作结果
     */
    @PostMapping
    public boolean addMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    /**
     * 修改膳食信息
     * @param meal 膳食对象
     * @return 操作结果
     */
    @PutMapping
    public boolean updateMeal(@RequestBody Meal meal) {
        return mealService.updateById(meal);
    }

    /**
     * 删除膳食信息
     * @param id 膳食ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public boolean deleteMeal(@PathVariable Integer id) {
        return mealService.removeById(id);
    }
}