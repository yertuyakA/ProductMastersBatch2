package org.example;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MasterCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через MasterCard карту: " + amount);
    }
}
