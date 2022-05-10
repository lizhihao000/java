package com.qdc.demoeurekaauth_server;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@EnableAuthorizationServer
@SpringBootApplication
public class DemoEurekaAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaAuthServerApplication.class, args);
    }

}
