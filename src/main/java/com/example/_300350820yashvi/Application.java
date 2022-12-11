package com.example._300350820yashvi;

import com.example._300350820yashvi.entities.Salesman;
import com.example._300350820yashvi.repositories.SalesmanRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
        @Bean
	CommandLineRunner commandLineRunner(SalesmanRepo repo){
        return args -> {
			repo.save(new Salesman(1, "Jessica LAm", "Washing Machine", 5000, new Date()));
			repo.save(new Salesman(13, "janniono Sam","Refrigerator", 8000, new Date()));

			repo.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }
    }


