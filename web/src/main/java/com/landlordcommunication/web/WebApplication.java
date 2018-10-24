package com.landlordcommunication.web;


import com.landlordcommunication.web.models.*;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Residence.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(UserToResidence.class)
                .addAnnotatedClass(Message.class)
                .buildSessionFactory();
    }
}
