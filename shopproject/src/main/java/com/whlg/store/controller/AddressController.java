package com.whlg.store.controller;

import com.whlg.store.entity.Address;
import com.whlg.store.service.IAddressService;
import com.whlg.store.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 
@RestController
@RequestMapping("/address")
@Api(tags = "地址模块")
public class AddressController extends BaseController{

    @Autowired
    private IAddressService iAddressService;

    @PostMapping("/addAddress")
    @ApiOperation("添加地址接口")
    public JsonResult<Void> addAddress(@RequestBody Address address){
            iAddressService.AddAddress(address);
            return new JsonResult<Void>(OK);
        }

    @PostMapping("/editAddress")
    @ApiOperation("更新地址接口")
    public JsonResult<Void> editAddress(@RequestBody Address address){
        System.out.println(address);
        iAddressService.editAddress(address);
        return new JsonResult<Void>(OK);
    }

    @DeleteMapping("/deleteAddress")
    @ApiOperation("删除地址接口")
    public JsonResult<Void> deleteAddress(int aid,int uid){
            iAddressService.removeAddress(aid,uid);
            return new JsonResult<Void>(OK);
    }

    @GetMapping("/getList")
    @ApiOperation("获取所有地址接口")
    public JsonResult<List<Address>> getListByUid(int uid){
            List<Address> addressList=iAddressService.getListByUid(uid);
            System.out.println(addressList);
            return new JsonResult<List<Address>>(OK,addressList);
    }
}
