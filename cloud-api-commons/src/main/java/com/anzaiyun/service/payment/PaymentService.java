package com.anzaiyun.service.payment;

import com.anzaiyun.entity.Payment;

public interface PaymentService {

    public boolean AddPayment(Payment payment);

    public boolean AddPayments(Payment[] payments);

    public Payment FindPaymentBylid(Integer l_id);

    public Payment[] FindPayments();
}
