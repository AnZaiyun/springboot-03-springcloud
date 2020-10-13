package com.anzaiyun.ConsumerOrder.FeginService;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginLogConf {

    //配置类中添加feign的日志类
    @Bean
    Logger.Level feignLoggerlevel(){
        /**
         * 设置日志级别
         * NONE默认的，不展示任何日志
         * BASIC仅记录请求方法、url、响应状态码及执行时间
         * HEADERS除了basic中的信息，还求请求头和响应头信息
         * FULL除了headers中的信息，还有请求和响应的正文及元数据
         */
        return Logger.Level.FULL;
    }
}
