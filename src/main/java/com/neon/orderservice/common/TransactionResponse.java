package com.neon.orderservice.common;

import com.neon.orderservice.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Order order;
    private String transactionId;
    private double amount;
    private String message;
}
