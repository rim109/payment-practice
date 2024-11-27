package com.paymentpractice.domain.payment.service;

import com.paymentpractice.domain.order.model.Order;
import com.paymentpractice.domain.order.repository.OrderRepository;
import com.paymentpractice.domain.payment.dto.PaymentRequest;
import com.paymentpractice.domain.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public PaymentRequest findPayment(String orderNo) {
        Order order = orderRepository.findOrderAndPaymentAndUser(orderNo).orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));

        return PaymentRequest.builder()
                .buyerName(order.getUser().getName())
                .buyerEmail(order.getUser().getEmail())
                .buyerAddress(order.getUser().getAddress())
                .paymentPrice(order.getPayment().getPrice())
                .itemName(order.getName())
                .orderNo(order.getOrderNo())
                .build();
    }
}