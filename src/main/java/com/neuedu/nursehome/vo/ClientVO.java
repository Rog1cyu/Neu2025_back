package com.neuedu.nursehome.vo;

import lombok.Data;

@Data
public class ClientVO {
    private Integer client_id;
    private String name;
    private String gender;
    private String birth_date;
    private String phone;
    private String bed_code;
    private String nurse_name;
}
