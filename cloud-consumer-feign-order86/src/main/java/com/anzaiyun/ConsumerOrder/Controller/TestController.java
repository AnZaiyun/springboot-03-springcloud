package com.anzaiyun.ConsumerOrder.Controller;

import com.anzaiyun.ConsumerOrder.Balance.LoadBalancer;
import com.anzaiyun.ConsumerOrder.FeginService.PaymentFeginService;
import com.anzaiyun.entity.CommonResult;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);

//    public static final String PAYMENT_URL = "http://localhost:8001";
//    改为微服务名称
//    public static final String PAYMENT_URL = "http://cloud-provider-payment";
    @Resource
    private PaymentFeginService paymentFeginService;

    //自定义的负载均衡
    @Resource
    private LoadBalancer loadBalancer;

    //对于注册进eureka的微服务，可以通过服务发现的方式来获取服务信息
    @Resource
    private DiscoveryClient discoveryClient;

    //测试自定义均衡负载
    @RequestMapping("/con/1")
    public String TestGetPayments(){
        return "消费端(feign)："+paymentFeginService.TestGetPayments().toString();
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
//        if(instances == null || instances.size()<=0){
//            return null;
//        }
//
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//        logger.info("uri is: "+uri);
//        return "消费端（eureka-自定义负载均衡）："+restTemplate.getForObject(uri.toString()+"/test/1",CommonResult.class);
    }
}
