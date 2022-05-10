package com.qdc.demoeurekacustmer1.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//配置类，获得restTemplate类的实例
@Configuration
public class RibbonConfig {
//    类实例化对象
    @Bean
    @LoadBalanced//加载均衡
//    通过RestTemplate（配置类）对象中的方法，调用提供者中的接口（数据）
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
