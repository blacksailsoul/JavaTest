package com.whlg.store.service;

import com.whlg.store.entity.Product;

public interface ICartService {

    Product getByPid(Integer pid);

    void  deletePro(Integer pid);


    /**
     * @param product
     */
    void addCart(Product product);
}
