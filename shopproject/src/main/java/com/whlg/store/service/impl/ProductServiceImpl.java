package com.whlg.store.service.impl;

import com.whlg.store.entity.Product;
import com.whlg.store.mapper.ProductMapper;
import com.whlg.store.service.IProductService;
import com.whlg.store.service.ex.SelectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getByPid(Integer pid) {
//        1.调用持久层查询商品详情
        Product result =productMapper.retrieveByPid(pid);
        if(result == null){
            throw new SelectException("商品不存在");
        }

//        2.查询成功，返回商品对象
        return result;
    }

    @Override
    public List<Product> getByBigCategory(Integer bigCategory) {
        return productMapper.retrieveByBigCategory(bigCategory);
    }

    @Override
    public List<Product> getByBigAndSmallCategory(Integer bigCategory, Integer smallCategory) {
        return productMapper.retrieveByBigAndSmallCategory(bigCategory,smallCategory);
    }

    @Override
    public List<Product> getByTime() {
        return productMapper.retrieveByTime();
    }

    @Override
    public List<Product> getBySaleNum(Integer order) {
//        1:降序
//        2：升序

        if(order==1){
            return productMapper.retrieveBySaleNumUp();
        }else if(order==2){
            return productMapper.retrieveBySaleNumDown();
        }
        return null;
    }

    @Override
    public List<Product> getByPrice(Integer order) {
        if(order==1){
            return productMapper.retrieveByPriceUp();
        }else if(order==2){
            return productMapper.retrieveByPriceDown();
        }
        return null;
    }
}
