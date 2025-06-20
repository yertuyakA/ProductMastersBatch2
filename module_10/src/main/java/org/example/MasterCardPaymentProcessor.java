package org.example;

import java.math.BigDecimal;

public class MasterCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через MasterCard карту: " + amount);
    }
}
