package com.anzaiyun.ProviderPayment.Controller;

import com.anzaiyun.entity.CommonResult;
import com.anzaiyun.entity.Payment;
import com.anzaiyun.service.payment.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    PaymentService paymentService ;

    @RequestMapping("/1")
    public CommonResult TestGetPayments(){

        Payment payment = paymentService.FindPaymentBylid(1);

        //使用RestTemplate远程调用该服务时，此处返回的类型与远程调用获得的类型一致
        return new CommonResult(200,"8002:success",payment);
    }
}
