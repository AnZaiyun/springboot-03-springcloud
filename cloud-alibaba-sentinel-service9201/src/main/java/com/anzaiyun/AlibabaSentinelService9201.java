package com.anzaiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelService9201 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelService9201.class,args);
    }
}
