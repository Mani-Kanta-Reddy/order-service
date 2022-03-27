package com.neon.orderservice.common;

import com.neon.orderservice.order.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
