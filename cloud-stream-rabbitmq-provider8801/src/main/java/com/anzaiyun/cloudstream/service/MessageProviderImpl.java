package com.anzaiyun.cloudstream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 表示当前这个类是source，负责生产消息，并且发送给channel
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider{

    //消息发送管道，消息将保存在这里
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial:"+serial);
        return "serial:"+serial;
    }
}
