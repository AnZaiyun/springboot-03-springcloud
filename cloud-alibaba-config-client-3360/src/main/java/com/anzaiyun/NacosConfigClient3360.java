package com.anzaiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3360 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3360.class,args);
    }
}
