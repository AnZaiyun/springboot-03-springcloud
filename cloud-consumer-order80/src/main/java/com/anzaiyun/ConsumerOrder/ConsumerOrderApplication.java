package com.anzaiyun.ConsumerOrder;

import com.anzaiyun.RibbonConf.RibbonConfByRandom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//自定义的负载均衡会导致RestTemplate不可用，原因未知
//@RibbonClient(name = "cloud-provider-payment",configuration = RibbonConfByRandom.class)
@RibbonClient(name = "cloud-provider-payment")
public class ConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class,args);
    }
}
