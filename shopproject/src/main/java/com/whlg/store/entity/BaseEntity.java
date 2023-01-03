package com.whlg.store.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
 

@Data
public class BaseEntity {
    @ApiModelProperty("创建人")
    private String createdUser;
    @ApiModelProperty("创建时间")
    private Date createdTime;
    @ApiModelProperty("修改人")
    private String changeUser ;
    @ApiModelProperty("修改时间")
    private Date changeTime;


}
