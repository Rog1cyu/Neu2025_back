package com.neuedu.nursehome.controller;

import com.neuedu.nursehome.entity.LoginRequest;
import com.neuedu.nursehome.entity.LoginResponse;
import com.neuedu.nursehome.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
