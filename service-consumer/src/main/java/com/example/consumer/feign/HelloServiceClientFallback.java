package com.example.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceClientFallback implements HelloServiceClient {
    @Override
    public String hello() {
        return "Service call failed, this is the fallback response.";
    }
}