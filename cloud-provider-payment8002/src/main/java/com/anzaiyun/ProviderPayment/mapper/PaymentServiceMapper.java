package com.anzaiyun.ProviderPayment.mapper;

import com.anzaiyun.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServiceMapper {

    public Integer AddPayment(Payment payment);

    public boolean AddPayments(Payment[] payments);

    public Payment FindPaymentBylid(Integer l_id);

    public Payment[] FindPayments();

}
