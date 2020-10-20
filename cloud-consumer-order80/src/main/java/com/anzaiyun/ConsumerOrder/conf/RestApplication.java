package com.anzaiyun.ConsumerOrder.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestApplication {
    @Bean
    //开启负载均衡（使用Ribbon的自定义负载均衡后，关闭该注解）
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
