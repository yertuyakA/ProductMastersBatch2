package org.example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependencyInjectorConfig {

    @Bean
    public PaymentProcessor visaCardPaymentProcessor() {
        return new VisaCardPaymentProcessor();
    }

    @Bean
    public PaymentProcessor masterCardPaymentProcessor() {
        return new MasterCardPaymentProcessor();
    }

    @Bean
    public PaymentProcessor bitcoinPaymentProcessor() {
        return new BitcoinPaymentProcessor();
    }

    @Bean
    public PaymentProcessor plovCoinPaymentProcessor() {
        return new PlovCoinPaymentProcessor();
    }


    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public OrderService orderService() {
        return new OrderService();
    }
}
