package com.paymentpractice.domain.payment.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentRequest {
    private String orderNo;
    private String itemName;
    private String buyerName;
    private Long paymentPrice;
    private String buyerEmail;
    private String buyerAddress;

    @Builder
    public PaymentRequest(String orderNo, String itemName, Long paymentPrice, String buyerName, String buyerEmail, String buyerAddress) {
        this.orderNo = orderNo;
        this.itemName = itemName;
        this.paymentPrice = paymentPrice;
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.buyerAddress = buyerAddress;
    }
}