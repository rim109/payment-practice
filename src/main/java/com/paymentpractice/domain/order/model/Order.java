package com.paymentpractice.domain.order.model;

import com.paymentpractice.domain.payment.model.Payment;
import com.paymentpractice.domain.user.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;
    private String name;
    private String orderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Builder
    public Order(Long price, String itemName, String orderNo, User user, Payment payment) {
        this.price = price;
        this.name = itemName;
        this.orderNo = orderNo;
        this.user = user;
        this.payment = payment;
    }
}
