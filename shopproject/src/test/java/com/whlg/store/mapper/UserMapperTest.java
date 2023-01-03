package com.whlg.store.mapper;

import com.whlg.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest{
//注入mapper层对象


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test001");
        user.setPassword("123");
        user.setCreatedUser("test001");
        user.setCreatedTime(new Date());
        user.setChangeUser("test001");
        user.setChangeTime(new Date());
        userMapper.insertUser(user);

        System.out.println("成功");
    }

    @Test
    public void testFindByUsername() {
        User result = userMapper.findByUsername("test001");
        System.out.println(result);
    }
}