package com.anzaiyun.ProviderPayment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.anzaiyun.ProviderPayment.mapper")
public class ProviderPaymentZK8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentZK8002Application.class,args);
    }
}
