package com.x.xserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class XserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(XserverApplication.class, args);
    }

}
