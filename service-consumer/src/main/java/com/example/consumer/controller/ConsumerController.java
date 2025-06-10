package com.example.consumer.controller;

import com.example.consumer.feign.HelloServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    @Autowired
    private HelloServiceClient helloServiceClient;

    @GetMapping("/hello")
    public String hello() {
        return "Consumer received: " + helloServiceClient.hello();
    }
}