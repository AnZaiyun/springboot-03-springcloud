package com.anzaiyun.cloudrabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Producer implements RabbitTemplate.ConfirmCallback{
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void produce() {
        String message =  new Date() + "Beijing";
        System.out.println("生产者生产消息=====" + message);
        rabbitTemplate.convertAndSend("rabbitmq_queue",  message);

        Message message1 = new Message(message.getBytes(),new MessageProperties());
        rabbitTemplate.send("rabbitmq_queue",  message1);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调函数。。。");
    }
}
