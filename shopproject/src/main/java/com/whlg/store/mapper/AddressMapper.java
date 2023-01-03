package com.whlg.store.mapper;

import com.whlg.store.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    //往地址表中添加一条数据
    int insertAddress(Address address);

    //更新地址表
   int updateAddress(Address address);

    Address findById(int aid);

   //删除地址表
   int deleteByAidAndUid(int aid,int uid);

   //根据uid显示地址数据
    List<Address> findAll(int uid);
}
