package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("care_records")
public class CareRecord {

    @TableId(type = IdType.AUTO)
    private Integer recordId;

    private Integer clientId;

    private Integer itemId;

    private Integer nurseId;

    private Date orderTime;

    private Date completionTime;

    private String status; // 已完成 / 未完成

    private String remarks;
}
