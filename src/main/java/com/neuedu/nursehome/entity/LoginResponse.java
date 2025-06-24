package com.neuedu.nursehome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String role;
    private Integer staffId;
}
