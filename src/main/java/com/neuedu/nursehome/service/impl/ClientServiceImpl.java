package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.nursehome.entity.Client;
import com.neuedu.nursehome.mapper.ClientMapper;
import com.neuedu.nursehome.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {
}
