package com.neuedu.nursehome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.nursehome.entity.Bed;
import com.neuedu.nursehome.service.BedService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @GetMapping
    public Page<Bed> list(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(required = false) String keyword,
                          @RequestParam(required = false) String status) {
        QueryWrapper<Bed> wrapper = new QueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.lambda().like(Bed::getBedCode, keyword);
        }
        if (status != null && !status.isEmpty()) {
            wrapper.lambda().eq(Bed::getStatus, status);
        }
        return bedService.page(new Page<>(page, size), wrapper);
    }

    @PostMapping
    public boolean create(@RequestBody Bed bed) {
        bed.setStatus("available");
        return bedService.save(bed);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Bed bed) {
        bed.setBedId(id);
        return bedService.updateById(bed);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bedService.removeById(id);
    }

    @GetMapping("/{id}")
    public Bed getById(@PathVariable Integer id) {
        return bedService.getById(id);
    }
}
