package com.neuedu.nursehome.service;

import com.neuedu.nursehome.entity.LoginRequest;
import com.neuedu.nursehome.entity.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);
}
