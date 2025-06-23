package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.CareRecord;
import com.neuedu.nursehome.mapper.CareRecordMapper;
import com.neuedu.nursehome.service.CareRecordService;
import org.springframework.stereotype.Service;

@Service
public class CareRecordServiceImpl extends ServiceImpl<CareRecordMapper, CareRecord> implements CareRecordService {
}
