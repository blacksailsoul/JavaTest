package com.whlg.store.controller;


import com.whlg.store.entity.Product;
import com.whlg.store.service.ICartService;
import com.whlg.store.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Api(tags = "购物车模块")
public class CartController extends BaseController{


    private ICartService iCartService;

    @PostMapping("/addCart")
    @ApiOperation("添加购物车接口")
    public JsonResult<List<Product>> addproCart(@RequestBody Product product){
        iCartService.addCart(product);
        return new JsonResult<List<Product>>(OK);
    }

    @DeleteMapping("/deleteCart")
    @ApiOperation("删除购物车商品接口")
    public JsonResult<Integer> deleteCart(int pid){
        iCartService.deletePro(pid);
        return new JsonResult<Integer>(OK);
    }
}
