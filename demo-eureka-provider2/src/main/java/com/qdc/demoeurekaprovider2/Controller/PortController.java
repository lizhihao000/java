package com.qdc.demoeurekaprovider2.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {
    //来源于yml文件中的server.port
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/port")
    public String testport(){
        return "hello,I'm from"+port;
    }

}
