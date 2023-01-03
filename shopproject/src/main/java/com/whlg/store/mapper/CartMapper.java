package com.whlg.store.mapper;

import com.whlg.store.entity.Address;
import com.whlg.store.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {
    List<Product> addCartByPid(Product product);

    /**
     * @param pid
     * @return
     */
    int deleteBypid(int pid);


    List<Product> findAllpro(int pid);
}
