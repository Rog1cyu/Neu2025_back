package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("staff")
public class Staff {

    @TableId(type = IdType.AUTO)
    private Integer staffId;

    private String username;

    private String password;

    private String name;

    private String gender; // 男 / 女

    private String role; // admin / nurse

    private String phone;

    private String status;
}
