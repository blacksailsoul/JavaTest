package com.whlg.store.service;

import com.whlg.store.service.ex.ServiceException;
import com.whlg.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest{
    @Autowired
    private IUserService iUserService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("test004");
        user.setPassword("123456");
        try{
            iUserService.addUser(user);
        }catch (ServiceException e){
            System.out.println("注册失败"+e.getMessage());
        }
    }

    @Test
    public void testLogin() {
        User user = iUserService.login("tes3","123456");
        System.out.println(user);
    }
}