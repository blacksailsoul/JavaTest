package com.whlg.store.mapper;

import com.whlg.store.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProductMapper {
//    增 create
//    删 delete
//    改 update
//    查 retrieve

    Product retrieveByPid(Integer pid);

    List<Product> retrieveByBigCategory(Integer bigCategory);

    List<Product> retrieveByBigAndSmallCategory(Integer bigCategory,Integer smallCategory);

    List<Product> retrieveByTime();

    List<Product> retrieveBySaleNumUp();

    List<Product> retrieveBySaleNumDown();

    List<Product> retrieveByPriceUp();

    List<Product> retrieveByPriceDown();
}
