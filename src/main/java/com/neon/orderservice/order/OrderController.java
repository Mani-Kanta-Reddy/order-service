package com.neon.orderservice.order;

import com.neon.orderservice.common.TransactionRequest;
import com.neon.orderservice.common.TransactionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/place-order")
    public TransactionResponse placeOrder(@RequestBody TransactionRequest request) {
        return service.placeOrder(request);
    }
}
