package com.qdc.demoeurekaauth_server.Controller;

import com.qdc.demoeurekaauth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class UserController {
    @Autowired
    private UserService userService;

}
