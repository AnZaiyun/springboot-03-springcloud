package com.anzaiyun.ProviderPayment.service;

import com.anzaiyun.ProviderPayment.mapper.PaymentServiceMapper;
import com.anzaiyun.entity.Payment;
import com.anzaiyun.service.payment.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    private Logger logger = Logger.getLogger(PaymentServiceImpl.class);

    @Autowired
    PaymentServiceMapper paymentServiceMapper;

    @Override
    public boolean AddPayment(Payment payment) {
        return false;
    }

    @Override
    public boolean AddPayments(Payment[] payments) {
        return false;
    }

    @Override
    @HystrixCommand(fallbackMethod = "FindPaymentBylid_Timeout",threadPoolKey = "threadPoolKey_test_1",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            //这里表示调用此方法的线程，最多只等待3秒，超过3秒无响应，触发降级，调用指定方法
    })
    public Payment FindPaymentBylid(Integer l_id) {
        int timeNumber = 1;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return paymentServiceMapper.FindPaymentBylid(l_id);
    }

    //FindPaymentBylid服务降级时调用的方法
    public Payment FindPaymentBylid_Timeout(Integer l_id) {
        System.out.println("触发降级。。。");
        return paymentServiceMapper.FindPaymentBylid(2);
    }
    /**
     * @author anzaiyun
     * @date 2020/10/20
     */
    @Override
    public Payment[] FindPayments() {
        return paymentServiceMapper.FindPayments();
    }
}
