package com.qdc.demoeurekacustmer1;

import com.qdc.demoeurekacustmer1.utils.HttpClientWithBasicAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.util.HashMap;
import java.util.Map;
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaCustmer1Application {

    public static void main(String[] args) {

        SpringApplication.run(DemoEurekaCustmer1Application.class,args);
        HttpClientWithBasicAuth auth=new HttpClientWithBasicAuth();
        String url="http://localhost:8081/oauth/token";
        Map<String,String> formData=new HashMap<>();
        formData.put("grant_type","client_credentials");
        formData.put("scope","all");
        String result = auth.send(url, "test", "123456", formData);
        System.out.println(result);
    }

}
