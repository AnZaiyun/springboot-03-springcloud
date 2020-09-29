package com.anzaiyun.ConsumerOrder.Controller;

import com.anzaiyun.ConsumerOrder.Balance.LoadBalancer;
import com.anzaiyun.entity.CommonResult;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);

//    public static final String PAYMENT_URL = "http://localhost:8001";
//    改为微服务名称
    public static final String PAYMENT_URL = "http://cloud-provider-hystrix-payment";
    @Resource
    private RestTemplate restTemplate;

    //自定义的负载均衡
    @Resource
    private LoadBalancer loadBalancer;

    //对于注册进eureka的微服务，可以通过服务发现的方式来获取服务信息
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/con/1")
    public String TestGetPayments(){

        CommonResult commonResult = restTemplate.getForEntity(PAYMENT_URL+"/test/1", CommonResult.class).getBody();

        return "消费端（hystrix）："+commonResult.toString();
    }

    @RequestMapping("/con/2")
    public String TestGetPayments2(){

        String result = restTemplate.getForEntity(PAYMENT_URL+"/test/2", String.class).getBody();

        return "消费端（hystrix）："+result;
    }


}
