package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("beds")
public class Bed {

    @TableId(type = IdType.AUTO)
    private Integer bedId;

    private String bedCode;

    private String description;

    private String status; // 可用 / 占用 / 停用
}
