package com.anzaiyun.ProviderPayment.service;

import com.anzaiyun.ProviderPayment.mapper.PaymentServiceMapper;
import com.anzaiyun.entity.Payment;
import com.anzaiyun.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

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
    public Payment FindPaymentBylid(Integer l_id) {
        return null;
    }

    @Override
    public Payment[] FindPayments() {
        return paymentServiceMapper.FindPayments();
    }
}
