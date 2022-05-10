package com.qdc.demoeurakaserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoEurakaServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurakaServer2Application.class, args);
    }

}
