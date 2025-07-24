package kz.kop_flowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowersApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowersApplication.class, args);
    }
}


// Flowers (id, name, price, size, category_id)
// Category (id, name)
// Tags (id, flower_id, tag_name)
