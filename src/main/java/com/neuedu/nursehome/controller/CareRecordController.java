package com.neuedu.nursehome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.nursehome.entity.CareRecord;
import com.neuedu.nursehome.service.CareRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/care-records")
public class CareRecordController {

    private final CareRecordService careRecordService;

    public CareRecordController(CareRecordService careRecordService) {
        this.careRecordService = careRecordService;
    }

    @GetMapping
    public Page<CareRecord> list(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required = false) Integer clientId,
                                 @RequestParam(required = false) Integer itemId,
                                 @RequestParam(required = false) String status) {
        QueryWrapper<CareRecord> wrapper = new QueryWrapper<>();
        if (clientId != null) {
            wrapper.lambda().eq(CareRecord::getClientId, clientId);
        }
        if (itemId != null) {
            wrapper.lambda().eq(CareRecord::getItemId, itemId);
        }
        if (status != null && !status.isEmpty()) {
            wrapper.lambda().eq(CareRecord::getStatus, status);
        }
        return careRecordService.page(new Page<>(page, size), wrapper);
    }

    @PostMapping
    public boolean create(@RequestBody CareRecord careRecord) {
        return careRecordService.save(careRecord);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody CareRecord careRecord) {
        careRecord.setRecordId(id);
        return careRecordService.updateById(careRecord);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return careRecordService.removeById(id);
    }

    @GetMapping("/{id}")
    public CareRecord getById(@PathVariable Integer id) {
        return careRecordService.getById(id);
    }
}
