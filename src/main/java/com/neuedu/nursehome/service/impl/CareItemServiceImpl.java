package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.CareItem;
import com.neuedu.nursehome.mapper.CareItemMapper;
import com.neuedu.nursehome.service.CareItemService;
import org.springframework.stereotype.Service;

@Service
public class CareItemServiceImpl extends ServiceImpl<CareItemMapper, CareItem> implements CareItemService {
}
