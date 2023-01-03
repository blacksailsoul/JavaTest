package com.whlg.store.vo;

import lombok.Data;


@Data
public class CartVo {
    private  Integer cid;
    private  Integer pid;
    private  Integer uid;
    private  long price;
    private  Integer num;
    private  String title;
    private  String image;
    private  long  realPrice;
}
