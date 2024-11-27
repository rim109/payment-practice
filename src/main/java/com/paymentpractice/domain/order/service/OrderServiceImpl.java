package com.paymentpractice.domain.order.service;


import com.paymentpractice.domain.order.model.Order;
import com.paymentpractice.domain.order.repository.OrderRepository;
import com.paymentpractice.domain.payment.model.Payment;
import com.paymentpractice.domain.payment.model.PaymentStatus;
import com.paymentpractice.domain.payment.repository.PaymentRepository;
import com.paymentpractice.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;


    @Override
    public Order orderAuto(User user) {
        Payment payment = Payment.builder()
                .price(5000L)
                .status(PaymentStatus.READY)
                .build();
        paymentRepository.save(payment);

        Order order = Order.builder()
                .user(user)
                .price(5000L)
                .itemName("상품")
                .orderNo(UUID.randomUUID().toString())
                .payment(payment)
                .build();

        return orderRepository.save(order);
    }
}