package dev.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sachin.sharma
 */

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @GetMapping(value = "/v1/view" )
    public String getHomePageBody() {
        String greetingsMsg = "Hello, welcome to NIM world";
        greetingsMsg = greetingsMsg + "!!!!!!!!!";
        return greetingsMsg;
    }
}
