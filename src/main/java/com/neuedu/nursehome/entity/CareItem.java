package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("care_items")
public class CareItem {

    @TableId(type = IdType.AUTO)
    private Integer itemId;

    private String name;

    private String status; // 启用 / 停用

    private String description;
}
