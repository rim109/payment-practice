package com.paymentpractice.domain.payment.repository;

import com.paymentpractice.domain.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
