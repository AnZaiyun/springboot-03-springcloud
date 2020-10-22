package com.anzaiyun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    //获取微服务地址
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/order/getpay")
    public String paymentInfo(){
        // 仍使用restTemplate获取远程服务
        return "消费端（nacos:"+serverPort+"）。。。"+restTemplate.getForObject(serverUrl+"/getpay",String.class);
    }
}
