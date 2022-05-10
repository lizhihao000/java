package com.qdc.demoeurekaserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//开始服务端功能
@EnableEurekaServer
@SpringBootApplication
public class DemoEurekaServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaServer1Application.class, args);
    }

}
