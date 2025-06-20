package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private PaymentProcessor paymentProcessor;

    public OrderService() {
        System.out.println("Создался OrderService" + this);
    }

    public void makeOrder(BigDecimal amount) {
        // логика обрабатывания заказа
        paymentProcessor.processPayment(amount);
    }

}
