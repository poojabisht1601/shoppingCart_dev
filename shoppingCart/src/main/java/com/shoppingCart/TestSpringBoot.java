package com.shoppingCart;


import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;




@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)

public class TestSpringBoot {
    public static void main(String[] args)
    {
        SpringApplication.run( TestSpringBoot.class, args);
    }




}
