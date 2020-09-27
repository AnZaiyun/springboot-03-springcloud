package com.anzaiyun.ProviderPayment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.anzaiyun.ProviderPayment.mapper")
@EnableDiscoveryClient
public class ProviderPaymentCS8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentCS8002Application.class,args);
    }
}
