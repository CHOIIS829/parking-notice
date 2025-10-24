package com.nopark.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}
