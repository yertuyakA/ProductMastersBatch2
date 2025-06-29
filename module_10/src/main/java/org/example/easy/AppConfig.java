package org.example.easy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GreetingService greetingService() {
        String lang = System.getProperty("user.language");
        if ("ru".equalsIgnoreCase(lang)) {
            return new RussianGreetingService();
        } else {
            return new EnglishGreetingService();
        }
    }

    @Bean
    public Main mainApp() {
        return new Main();
    }
}
