package com.whlg.store.entity;

import lombok.Data;
import lombok.ToString;
 
@Data
@ToString(callSuper = true)
public class Address extends BaseEntity {
    private int aid;
    private String name;
    private String phone;
    private String province;
    private String city;
    private String county;
    private String detailArea;
    private String postCode;
    private int uid;
}
