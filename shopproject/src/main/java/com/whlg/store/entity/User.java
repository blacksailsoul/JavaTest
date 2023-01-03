package com.whlg.store.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
 
@Data
@ToString(callSuper = true)
public class User extends BaseEntity{
    @ApiModelProperty("用户ID")
    private Integer uid;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("地址")
    private String address;
}
