package com.anzaiyun.ProviderPayment.Controller;

import com.anzaiyun.entity.CommonResult;
import com.anzaiyun.entity.Payment;
import com.anzaiyun.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    PaymentService paymentService ;

    @Value("${server.port}")
    String httpPort;

    @RequestMapping("/1")
    public CommonResult TestGetPayments(){

        Payment payment = paymentService.FindPaymentBylid(1);

        //使用RestTemplate远程调用该服务时，此处返回的类型与远程调用获得的类型一致
        return new CommonResult(200,"8005:success",payment);
    }

    /**
     * @author anzaiyun
     * 对于结果不封装CommonResult
     */
    @RequestMapping("/3")
    public Payment TestGetPayments3(){
        Payment payment = paymentService.FindPaymentBylid(3);
        payment.setVc_serial(payment.getVc_serial()+":"+httpPort);
        return payment;
    }
}
