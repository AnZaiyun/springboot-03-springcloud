package com.anzaiyun.cloudrabbitmq.controller;

import com.anzaiyun.cloudrabbitmq.service.MsgProducer;
import com.anzaiyun.cloudrabbitmq.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    Producer producer;

    @Autowired
    MsgProducer msgProducer;

    @RequestMapping("/msg")
    @ResponseBody
    public String contextLoads() {
        producer.produce();

        return "producer.produce();";
    }

    @RequestMapping("/msg/a")
    @ResponseBody
    public String contextLoadsA() {

        msgProducer.sendMsg("A开始发送第1个消息。。。");

        for(int i=1;i<=5;i++){
            msgProducer.sendMsgB("B开始发送第"+i+"个消息。。。");
        }

        return "msgProducer.sendMsgB()："+ UUID.randomUUID().toString();
    }

    @RequestMapping("/msg/all")
    @ResponseBody
    public String contextLoads1ToAll() {


        return "msgProducer.sendMsgB()："+ UUID.randomUUID().toString();
    }

    @RequestMapping("/msg/fanout")
    @ResponseBody
    public String fanoutExchange() {
        msgProducer.sendAll("http://localhost:4001/test/msg/a");

        return "发送广播接口信息给python队列：http://localhost:4001/test/msg/a  回调id："+ UUID.randomUUID().toString();
    }

    @RequestMapping("/msg/python")
    @ResponseBody
    public String sendToPython(){
        msgProducer.sendMsgPython("http://localhost:4001/test/msg/a");

        return "发送接口信息给python队列：http://localhost:4001/test/msg/a  回调id："+ UUID.randomUUID().toString();
    }
}
