package com.anzaiyun.cloudstream.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 启用绑定，表示当前类是sink，负责介绍channel发送过来的数据进行消费
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessage {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 表示监听sink的input，而在配置文件中配置了input，将其绑定在了一个指定的Exchange上获取数据
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者("+serverPort+")接收到的消息："+message.getPayload());
    }
}
