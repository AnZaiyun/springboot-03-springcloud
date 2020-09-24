package com.anzaiyun.ProviderPayment.Controller;

import com.anzaiyun.ProviderPayment.service.PaymentServiceImpl;
import com.anzaiyun.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    PaymentService paymentService ;

    @RequestMapping("/1")
    @ResponseBody
    public String TestGetPayments(){

        return paymentService.FindPaymentBylid(1).toString();
    }
}
