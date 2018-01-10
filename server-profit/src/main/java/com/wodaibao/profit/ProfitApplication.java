package com.wodaibao.profit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 入口 ,含@ComponentScan自动扫描同级包
 *
 */
@SpringBootApplication
public class ProfitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfitApplication.class, args);
    }
}