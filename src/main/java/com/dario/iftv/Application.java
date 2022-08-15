package com.dario.iftv;

import com.dario.iftv.repository.jpa.CustomerRepository;
import com.dario.iftv.repository.jpa.entity.CustomerEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new CustomerEntity("Jack", "Bauer"));
            repository.save(new CustomerEntity("Chloe", "O'Brian"));
            repository.save(new CustomerEntity("Kim", "Bauer"));
            repository.save(new CustomerEntity("David", "Palmer"));
            repository.save(new CustomerEntity("Michelle", "Dessler"));
        };
    }

}
