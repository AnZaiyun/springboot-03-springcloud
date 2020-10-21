package com.anzaiyun.cloudconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    // 当配置中心和本地配置同时存在时，配置中心的配置会覆盖本地的，以配置中心的为准
    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/name")
    @ResponseBody
    public String getConfigInfo(){
        return name;
    }
}
