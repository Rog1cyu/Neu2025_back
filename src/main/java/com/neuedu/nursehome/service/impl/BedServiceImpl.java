package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.Bed;
import com.neuedu.nursehome.mapper.BedMapper;
import com.neuedu.nursehome.service.BedService;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {
}
