package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("clients")
public class Client {

    @TableId(type = IdType.AUTO)
    private Integer clientId;

    private String name;

    private String gender;

    private Date birthDate;

    private String phone;

    private Integer bedId;

    private Integer nurseId;
}
