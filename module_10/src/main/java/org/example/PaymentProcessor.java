package org.example;

import java.math.BigDecimal;

public interface PaymentProcessor {
    void processPayment(BigDecimal amount);
}
