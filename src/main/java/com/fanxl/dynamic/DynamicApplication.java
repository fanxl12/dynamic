package com.fanxl.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:35
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.fanxl.dynamic.dao")
public class DynamicApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DynamicApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class, args);
    }
}
