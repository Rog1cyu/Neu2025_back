package com.neuedu.nursehome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.nursehome.entity.LoginRequest;
import com.neuedu.nursehome.entity.LoginResponse;
import com.neuedu.nursehome.entity.Staff;
import com.neuedu.nursehome.mapper.StaffMapper;
import com.neuedu.nursehome.service.LoginService;
import com.neuedu.nursehome.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        Staff staff = staffMapper.selectOne(
                new QueryWrapper<Staff>().eq("username", request.getUsername())
        );

        /*if (staff == null || !BCrypt.checkpw(request.getPassword(), staff.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }*/
        if (!request.getPassword().equals(staff.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        String token = JwtUtil.generateToken(staff.getUsername(), staff.getRole());

        return new LoginResponse(token, staff.getRole());
    }
}
