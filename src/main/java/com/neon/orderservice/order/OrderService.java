package com.neon.orderservice.order;

import com.neon.orderservice.common.Payment;
import com.neon.orderservice.common.TransactionRequest;
import com.neon.orderservice.common.TransactionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate template;

    public OrderService(OrderRepository repository, RestTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public TransactionResponse placeOrder(TransactionRequest request) {
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getAmount());
        //since order details for the current order is set on payment do rest-call to PAYMENT-SERVICE
        //use restTemplate to do rest-api-call
        Payment paymentResponse = template.postForObject("http://localhost:8081/payments/doPayment", payment, Payment.class);
        String response = paymentResponse.getStatus().equals("success") ? "payment processed successfully" : "payment failed but the order is saved to cart";
        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }
}
