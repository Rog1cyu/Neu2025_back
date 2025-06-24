package com.neuedu.nursehome.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date orderTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date completionTime;

    private String status; // 已完成 / 未完成

    private String remarks;
}
