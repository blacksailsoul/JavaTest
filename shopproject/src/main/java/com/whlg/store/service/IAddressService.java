package com.whlg.store.service;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import com.whlg.store.entity.Address;

import java.util.List;

public interface IAddressService {
    /**
     * @param address
     */
    void AddAddress(Address address);
    void editAddress(Address address);
    void removeAddress(int aid,int uid);
    List<Address> getListByUid(int uid);
}
