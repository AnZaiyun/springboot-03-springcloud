package com.anzaiyun.cloudrabbitmq.controller;

import com.anzaiyun.cloudrabbitmq.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    Producer producer;

    @RequestMapping("/msg")
    @ResponseBody
    public String contextLoads() {
        producer.produce();

        return "producer.produce();";
    }
}
