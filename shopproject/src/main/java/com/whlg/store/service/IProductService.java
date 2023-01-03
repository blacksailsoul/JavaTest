package com.whlg.store.service;

import com.whlg.store.entity.Product;

import java.util.List;

public interface IProductService {

    /**
     * 根据pid查找商品
     * @param pid
     * @return
     */
    Product getByPid(Integer pid);

    /**
     * 根据商品最高类别查找商品数据
     * @param bigCategory
     * @return
     */
    List<Product> getByBigCategory(Integer bigCategory);

    List<Product> getByBigAndSmallCategory(Integer bigCategory,Integer smallCategory);

    List<Product> getByTime();

    List<Product> getBySaleNum(Integer order);

    List<Product> getByPrice(Integer order);
}
