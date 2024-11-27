package com.paymentpractice.domain.order.repository;

import com.paymentpractice.domain.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o" +
            " left join fetch o.payment p" +
            " left join fetch o.user m" +
            " where o.orderNo = :orderUid")
    Optional<Order> findOrderAndPaymentAndUser(String orderNo);

    @Query("select o from Order o" +
            " left join fetch o.payment p" +
            " where o.orderNo = :orderUid")
    Optional<Order> findOrderAndPayment(String orderNo);
}
