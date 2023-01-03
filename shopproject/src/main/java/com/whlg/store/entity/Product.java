package com.whlg.store.entity;

import lombok.Data;

import java.util.Date;
 
@Data
public class Product {
    private Integer pid;
    private String title;
    private String sellPoint;
    private long price;
    private String image;
    private Integer stock;
    private Integer bigCategory;
    private Integer smallCategory;
    private Integer colorCategory;
    private Date createdTime;
    private Integer saleNum;
}
