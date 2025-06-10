package com.example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider", fallback = HelloServiceClientFallback.class)
public interface HelloServiceClient {

    @GetMapping("/api/hello")
    String hello();
}