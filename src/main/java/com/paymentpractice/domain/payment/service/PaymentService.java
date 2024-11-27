package com.paymentpractice.domain.payment.service;

import com.paymentpractice.domain.payment.dto.PaymentRequest;

public interface PaymentService {
    PaymentRequest findPayment(String orderNo);
}
