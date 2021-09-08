package com.atlacademy.newsmvc.app.demo;

import com.atlacademy.newsmvc.app.demo.config.Student;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewsMvcAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cnt=
                SpringApplication.run(NewsMvcAppApplication.class, args);
       // System.out.println("Application start : "+(Student) cnt.getBean("student"));
    }

}


/**
 * singleton
 * prototype
 * ----  web ----
 * request
 * session
 * application
 * websocket
 */
