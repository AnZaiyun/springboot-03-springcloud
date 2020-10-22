package com.anzaiyun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @RequestMapping("/a")
    public String testA(){
        return "this is testA...";
    }

    @RequestMapping("/b")
    public String testB(){
        return "this is testB...";
    }

    @RequestMapping("/c")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "this is testC...";
    }
}
