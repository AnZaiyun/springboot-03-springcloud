package com.anzaiyun.ProviderPayment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.anzaiyun.ProviderPayment.mapper")
public class ProviderPaymentHY8010Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentHY8010Application.class,args);
    }
}
