package com.anzaiyun.ConsumerOrder.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestApplication {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
