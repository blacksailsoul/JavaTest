package com.whlg.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册处理拦截器的操作
 * */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    //允许get post delete方法的请求
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedOrigins("*");
    }
}
