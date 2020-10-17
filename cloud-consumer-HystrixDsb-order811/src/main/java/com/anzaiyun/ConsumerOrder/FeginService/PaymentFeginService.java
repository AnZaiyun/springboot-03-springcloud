package com.anzaiyun.ConsumerOrder.FeginService;

import com.anzaiyun.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment" ,fallback = PaymentFeginServiceFallback.class)
public interface PaymentFeginService {

    //RequestMapping的地址应该是服务端的完整地址，包含类上和方法上的
    @RequestMapping("/test/1")
    public CommonResult TestGetPayments();

    @RequestMapping("/test/2")
    public String TestGetPayments2();

}
