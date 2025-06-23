package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.Staff;
import com.neuedu.nursehome.mapper.StaffMapper;
import com.neuedu.nursehome.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
}
