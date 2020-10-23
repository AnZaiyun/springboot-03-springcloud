package com.anzaiyun.cloudrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudRabbitmqProducer4001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudRabbitmqProducer4001.class,args);
    }
}
