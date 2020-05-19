package com.staxrt.tutorial;

import com.staxrt.tutorial.config.DbConfigFake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * The type Application.
 */
@SpringBootApplication
public class Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        DbConfigFake dbConfigFake = context.getBean(DbConfigFake.class);
        System.out.println(dbConfigFake);
    }
}

