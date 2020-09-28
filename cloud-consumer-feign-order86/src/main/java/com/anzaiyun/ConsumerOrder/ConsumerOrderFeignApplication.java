package com.anzaiyun.ConsumerOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignApplication.class,args);
    }
}
