package com.airline.arrangment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Varadharajan on 26/05/20 13:51
 * @Projectname airline
 */

@RestController
public class DefaultController {

    @GetMapping("/")
    public String init() {

        return "Welcome to airline seat arrangement, hit /swagger-ui.html to access application";
    }
}
