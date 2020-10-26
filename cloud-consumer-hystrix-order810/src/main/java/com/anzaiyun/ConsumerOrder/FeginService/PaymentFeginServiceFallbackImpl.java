package com.anzaiyun.ConsumerOrder.FeginService;

import com.anzaiyun.entity.CommonResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeginServiceFallbackImpl implements PaymentFeginService{
    private final Logger logger = Logger.getLogger(this.getClass());

    //采用的feign接口远程调用服务的方式，当调用的服务发生超时时，设置服务降级方法
    @Override
    public CommonResult TestGetPayments() {
        logger.debug("Fegin远程调用方式--PaymentFeginServiceFallback:服务降级");
        return null;
    }

    @Override
    public String TestGetPayments2() {
        return null;
    }
}
