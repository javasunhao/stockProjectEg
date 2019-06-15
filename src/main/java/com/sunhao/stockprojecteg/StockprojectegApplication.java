package com.sunhao.stockprojecteg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sunhao.stockprojecteg.dao.mapper")
public class StockprojectegApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockprojectegApplication.class, args);
    }

}
