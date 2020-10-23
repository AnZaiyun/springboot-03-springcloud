package com.anzaiyun.cloudrabbitmq.service;

import com.anzaiyun.cloudrabbitmq.config.RabbitmqConfig;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = Logger.getLogger(this.getClass());

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容

    }

    public void sendMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A, RabbitmqConfig.ROUTINGKEY_A, content, correlationId);
    }

    public void sendMsgB(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B, RabbitmqConfig.ROUTINGKEY_B, content, correlationId);
    }
    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.debug(" 回调id:" + correlationData);
        if (ack) {
            logger.debug("消息成功消费");
        } else {
            logger.debug("消息消费失败:" + cause);
        }
    }

    /**
     * 消息发送，这里不设置routing_key,因为设置了也无效，发送端的routing_key写任何字符都会被忽略。
     * @param content
     */
    public void sendAll(String content) {
        rabbitTemplate.convertAndSend("my-fanout-exchange","", content);
    }
}
