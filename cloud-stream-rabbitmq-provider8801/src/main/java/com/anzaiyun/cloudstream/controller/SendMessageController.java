package com.anzaiyun.cloudstream.controller;

import com.anzaiyun.cloudstream.service.MessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;

    @RequestMapping("/sendmsg")
    public String sendMessage(){
        return messageProvider.send();
    }
}
