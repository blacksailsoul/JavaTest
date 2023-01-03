package com.whlg.store.service.impl;

import com.whlg.store.entity.Address;
import com.whlg.store.entity.User;
import com.whlg.store.mapper.AddressMapper;
import com.whlg.store.mapper.UserMapper;
import com.whlg.store.service.IAddressService;
import com.whlg.store.service.ex.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void AddAddress(Address address) {
        User user=userMapper.findByUid(address.getUid());
        if(user==null){
            throw new UserException("该用户数据不存在");
        }

        Date now=new Date();
        address.setCreatedUser(user.getUsername());
        address.setCreatedTime(now);
        address.setChangeUser(user.getUsername());
        address.setChangeTime(now);

        int rows=addressMapper.insertAddress(address);
        if(rows!=1){
            throw new InsertException("插入地址数据失败，请联系管理员");
        }

    }

    @Override
    public void editAddress(Address address) {
        if(address.getAid()==0){
            //进行插入
            User user=userMapper.findByUid(address.getUid());
            if(user==null){
                throw new UserException("该用户数据不存在");
            }

            Date now=new Date();
            address.setCreatedUser(user.getUsername());
            address.setCreatedTime(now);
            address.setChangeUser(user.getUsername());
            address.setChangeTime(now);

            int rows=addressMapper.insertAddress(address);
            if(rows!=1){
                throw new InsertException("插入地址数据失败，请联系管理员");
            }
        }
        else
        {
            //进行更新
            User user=userMapper.findByUid(address.getUid());
            if(user==null){
                throw new UserException("该用户数据不存在");
            }

            Address result=addressMapper.findById(address.getAid());
            if(result==null){
                throw new SelectException("该地址数据不存在");
            }
            if(result.getUid()!=address.getUid()){
                throw new SelectException("用户id错误");
            }

            Date now=new Date();
            address.setChangeUser(user.getUsername());
            address.setChangeTime(now);

            int rows=addressMapper.updateAddress(address);
            if(rows!=1){
                throw new UpdateException("更新地址数据失败,请联系管理员");
            }
        }
    }

    @Override
    public void removeAddress(int aid, int uid) {
        //判断用户数据是否存在
        User user=userMapper.findByUid(uid);
        if(user==null){
            throw new UserException("用户数据不存在");
        }
        //判断地址数据是否粗真乃
        Address address=addressMapper.findById(aid);
        if(address==null){
            throw new SelectException("地址数据不存在");
        }

        //删除
        int rows=addressMapper.deleteByAidAndUid(aid,uid);
        if(rows!=1){
            throw new DeleteException("删除数据失败，请联系管理员");
        }
    }

    @Override
    public List<Address> getListByUid(int uid) {
        //判断用户是否存在
        User user=userMapper.findByUid(uid);
        if(user==null){
            throw new UserException("该用户数据不存在");
        }
        //获取数据
        List<Address> addressList=addressMapper.findAll(uid);
        return addressList;
    }
}
