package com.paymentpractice.domain.order.service;

import com.paymentpractice.domain.order.model.Order;
import com.paymentpractice.domain.user.model.User;

public interface OrderService {
    Order orderAuto(User user);
}
