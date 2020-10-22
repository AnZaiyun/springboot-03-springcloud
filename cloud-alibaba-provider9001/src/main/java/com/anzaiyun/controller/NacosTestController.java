package com.anzaiyun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosTestController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getpay")
    public String getPayment(){
        return "生产端（nacos:"+serverPort+"）";
    }
}
