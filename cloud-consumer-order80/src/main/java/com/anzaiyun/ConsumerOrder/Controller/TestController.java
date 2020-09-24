package com.anzaiyun.ConsumerOrder.Controller;

import com.anzaiyun.entity.CommonResult;
import com.anzaiyun.entity.Payment;
import com.anzaiyun.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/con/1")
    @ResponseBody
    public CommonResult<Payment> TestGetPayments(){

        return restTemplate.getForObject(PAYMENT_URL+"/test/1", CommonResult.class);
    }
}
