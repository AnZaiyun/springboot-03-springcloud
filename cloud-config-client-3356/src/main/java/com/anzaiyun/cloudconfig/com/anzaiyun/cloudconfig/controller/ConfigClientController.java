package com.anzaiyun.cloudconfig.com.anzaiyun.cloudconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/name")
    @ResponseBody
    public String getConfigInfo(){
        return name;
    }
}
