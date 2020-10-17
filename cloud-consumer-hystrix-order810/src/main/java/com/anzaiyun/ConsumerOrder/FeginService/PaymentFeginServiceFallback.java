package com.anzaiyun.ConsumerOrder.FeginService;

import com.anzaiyun.entity.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeginServiceFallback implements PaymentFeginService{
    //采用的feign接口远程调用服务的方式，当调用的服务发生超时时，设置服务降级方法
    @Override
    public CommonResult TestGetPayments() {
        System.out.println("PaymentFeginServiceFallback:服务降级");
        return null;
    }

    @Override
    public String TestGetPayments2() {
        return null;
    }
}