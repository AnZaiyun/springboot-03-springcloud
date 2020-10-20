package com.anzaiyun.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudConfigClient3355 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3355.class,args);
    }
}
