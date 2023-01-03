package com.whlg.store.controller;

import com.whlg.store.entity.Product;
import com.whlg.store.service.IProductService;
import com.whlg.store.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
 
@RestController
@RequestMapping("/products")
@Api(tags="商品模块")
public class ProductController extends BaseController{
    @Autowired
    private IProductService iProductService;

    @GetMapping("/detail/{pid}")
    @ApiOperation("查询商品详情")
    public JsonResult<Product> getDetail(Integer pid){
        System.out.println(pid);
        Product data = iProductService.getByPid(pid);
        return new JsonResult<Product>(OK,data);
    }

    @GetMapping("/bigCategory")
    @ApiOperation("查找大类别商品")
    public JsonResult<List<Product>> getBigCategory(Integer bigCategory){
        List<Product> data = iProductService.getByBigCategory(bigCategory);
        return new JsonResult<List<Product>>(OK,data);
    }

    @GetMapping("/bigAndSmallCategory")
    @ApiOperation("查找大小类别商品")
    public JsonResult<List<Product>> getBigAndSmallCategory(Integer bigCategory,Integer smallCategory){
        List<Product> data = iProductService.getByBigAndSmallCategory(bigCategory,smallCategory);
        return new JsonResult<List<Product>>(OK,data);
    }

    @GetMapping("/orderByTime")
    @ApiOperation("按时间查找")
    public JsonResult<List<Product>> getByTime(){
        List<Product> data = iProductService.getByTime();
        return new JsonResult<List<Product>>(OK,data);
    }

    @GetMapping("/orderBySaleNum")
    @ApiOperation("按销量查找")
    public JsonResult<List<Product>> getBySaleNum(Integer order){
        List<Product> data = iProductService.getBySaleNum(order);
        return new JsonResult<List<Product>>(OK,data);
    }

    @GetMapping("/orderByPrice")
    @ApiOperation("按价格查找")
    public JsonResult<List<Product>> getByPrice(Integer order){
        List<Product> data = iProductService.getByPrice(order);
        return new JsonResult<List<Product>>(OK,data);
    }
}
