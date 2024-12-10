package com.paymentpractice.domain.order.controller;

import com.paymentpractice.domain.order.model.Order;
import com.paymentpractice.domain.order.service.OrderService;
import com.paymentpractice.domain.user.model.User;
import com.paymentpractice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("/order")
    public String order(
            @RequestParam(name = "msg", required = false) String msg,
            @RequestParam(name = "orderId", required = false) String id,
            Model model) {

        model.addAttribute("msg", msg);
        model.addAttribute("orderId", id);

        return "order";
    }

    @PostMapping("/order")
    public String autoOrder() {
        User user = userService.UserRegister();
        Order order = orderService.orderAuto(user);

        String msg = "주문 실패";
        if (order != null) {
            msg = "주문 성공";
        }

        String encode = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return "redirect:/order?msg=" + encode + "&orderId" + order.getOrderNo();
    }
}
