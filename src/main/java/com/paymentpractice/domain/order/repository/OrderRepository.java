package com.paymentpractice.domain.order.repository;

import com.paymentpractice.domain.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
