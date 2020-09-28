package com.anzaiyun.ConsumerOrder.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestApplication {
    @Bean
//    @LoadBalanced  //开启负载均衡（使用Ribbon的自定义负载均衡后，关闭该注解）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
