package com.stu.cloudlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.stu.cloudlibrary.mapper")  // 扫描你的 Mapper 包
public class CloudlibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudlibraryApplication.class, args);
    }
}
