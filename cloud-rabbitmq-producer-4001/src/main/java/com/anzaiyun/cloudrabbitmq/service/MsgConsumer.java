package com.anzaiyun.cloudrabbitmq.service;

import com.anzaiyun.cloudrabbitmq.config.RabbitmqConfig;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {

    private final Logger logger = Logger.getLogger(this.getClass());

    //一生产者一消费者
    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_A)
    public void process(String content) {
        logger.debug("接收处理队列A当中的消息： " + content);
    }

    //一生产者多消费者，消费者采用负载均衡方式消费
    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_B)
    public void processB1(String content) {
        logger.debug("处理器B1，接收处理队列B当中的消息： " + content);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_B)
    public void processB2(String content) {
        logger.debug("处理器B2，接收处理队列B当中的消息： " + content);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_B)
    public void processB3(String content) {
        logger.debug("处理器B3，接收处理队列B当中的消息： " + content);
    }

}
