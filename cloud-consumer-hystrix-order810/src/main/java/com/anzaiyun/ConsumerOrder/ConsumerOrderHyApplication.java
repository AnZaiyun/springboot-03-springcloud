package com.anzaiyun.ConsumerOrder;

import com.anzaiyun.RibbonConf.RibbonConfByRandom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "cloud-provider-hystrix-payment",configuration = RibbonConfByRandom.class)
@EnableFeignClients
@EnableHystrix
public class ConsumerOrderHyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderHyApplication.class,args);
    }
}
