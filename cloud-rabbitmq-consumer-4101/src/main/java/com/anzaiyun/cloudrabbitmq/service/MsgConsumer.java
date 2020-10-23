package com.anzaiyun.cloudrabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //一生产者一消费者
    @RabbitHandler
    @RabbitListener(queues = "QUEUE_A")
    public void process(String content) {
        logger.info("接收处理队列A当中的消息： " + content);
    }

}
