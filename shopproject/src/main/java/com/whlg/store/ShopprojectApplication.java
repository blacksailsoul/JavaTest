package com.whlg.store;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whlg.store.mapper")
public class ShopprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopprojectApplication.class, args);
    }

}
