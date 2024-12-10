package com.paymentpractice.domain.payment.controller;

import com.paymentpractice.domain.payment.dto.PaymentRequest;
import com.paymentpractice.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public String paymentPage(
            @PathVariable(name = "id", required = false) String id,
            Model model) {

        PaymentRequest req = paymentService.findPayment(id);
        model.addAttribute("request", req);
        return "payment";
    }

    @ResponseBody
    @PostMapping("/payment")
    public String autoOrder() {
        return "아직 미구현";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        return "fail";
    }
}
