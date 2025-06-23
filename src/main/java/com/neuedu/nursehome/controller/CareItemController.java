package com.neuedu.nursehome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.nursehome.entity.CareItem;
import com.neuedu.nursehome.service.CareItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/care-items")
public class CareItemController {

    private final CareItemService careItemService;

    public CareItemController(CareItemService careItemService) {
        this.careItemService = careItemService;
    }

    @GetMapping
    public Page<CareItem> list(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(required = false) String keyword,
                               @RequestParam(required = false) String status) {
        QueryWrapper<CareItem> wrapper = new QueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.lambda().like(CareItem::getName, keyword);
        }
        if (status != null && !status.isEmpty()) {
            wrapper.lambda().eq(CareItem::getStatus, status);
        }
        return careItemService.page(new Page<>(page, size), wrapper);
    }

    @PostMapping
    public boolean create(@RequestBody CareItem careItem) {
        return careItemService.save(careItem);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody CareItem careItem) {
        careItem.setItemId(id);
        return careItemService.updateById(careItem);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return careItemService.removeById(id);
    }

    @GetMapping("/{id}")
    public CareItem getById(@PathVariable Integer id) {
        return careItemService.getById(id);
    }
}
