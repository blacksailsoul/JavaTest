package com.whlg.store.entity;


import lombok.Data;
import lombok.ToString;
 
@Data
@ToString(callSuper = true)
public class LinkAddressUser extends BaseEntity{
    private int lid;
    private int aid;
    private int uid;
}
