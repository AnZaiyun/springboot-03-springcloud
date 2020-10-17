package com.anzaiyun.ConsumerOrder.Controller;

import com.anzaiyun.ConsumerOrder.FeginService.PaymentFeginService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
@DefaultProperties(defaultFallback = "TestGetPayments_global_timeout")
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);

    @Resource
    private PaymentFeginService paymentFeginService;

    //对于注册进eureka的微服务，可以通过服务发现的方式来获取服务信息
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/con/1")
    @HystrixCommand(fallbackMethod = "TestGetPayments_timeout",threadPoolKey = "threadPoolKey_test_1",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            //这里表示调用此方法的线程，最多只等待3秒，超过3秒无响应，触发降级，调用指定方法
    })
    public String TestGetPayments(){

        return "消费端（hystrix）："+paymentFeginService.TestGetPayments().toString();
    }

    public String TestGetPayments_timeout(){

        return "消费端（hystrix-消费端降级-专用）";
    }

    //该请求会超时，但是未配备专用的服务降级方法，会调用通用降级方法
    @RequestMapping("/con/2")
    @HystrixCommand
    public String TestGetPayments2(){

        return "消费端（hystrix）："+paymentFeginService.TestGetPayments().toString();
    }

    public String TestGetPayments_global_timeout(){

        return "消费端（hystrix-消费端降级-通用）";
    }

    //测试非压力测试
    @RequestMapping("/con/3")
    public String TestGetPayments3(){

        return "消费端（hystrix）："+paymentFeginService.TestGetPayments2();
    }


}
