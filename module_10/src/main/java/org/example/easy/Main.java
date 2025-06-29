package org.example.easy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static {
        System.setProperty("user.language", "ru");
    }

    @Autowired
    private GreetingService greetingService;

    public void run() {
        greetingService.sayHello();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Main app = context.getBean(Main.class);
        app.run();
    }
}
