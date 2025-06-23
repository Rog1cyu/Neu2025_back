package com.neuedu.nursehome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.nursehome.entity.Staff;
import com.neuedu.nursehome.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public Page<Staff> list(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size,
                            @RequestParam(required = false) String keyword,
                            @RequestParam(required = false) String status) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.lambda().like(Staff::getName, keyword);
        }
        if (status != null && !status.isEmpty()) {
            wrapper.lambda().eq(Staff::getStatus, status);
        }
        return staffService.page(new Page<>(page, size), wrapper);
    }

    @PostMapping
    public boolean create(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Staff staff) {
        staff.setStaffId(id);
        return staffService.updateById(staff);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return staffService.removeById(id);
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Integer id) {
        return staffService.getById(id);
    }
}
