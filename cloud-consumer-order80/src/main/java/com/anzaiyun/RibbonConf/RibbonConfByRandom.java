package com.anzaiyun.RibbonConf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfByRandom {

    @Bean
    public IRule myRule(){
        return new RandomRule();  //随机访问
    }
}
