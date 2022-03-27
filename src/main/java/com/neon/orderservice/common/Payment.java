package com.neon.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private int id;
    private String status;
    private String transactionId;
    private int orderId;
    private double amount;
}
