package com.anzaiyun.ConsumerOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderCSApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderCSApplication.class,args);
    }
}
