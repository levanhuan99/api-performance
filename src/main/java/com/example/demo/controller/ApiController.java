package com.example.demo.controller;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final Counter myApiCounter;

    public ApiController(MeterRegistry meterRegistry) {
        this.myApiCounter = meterRegistry.counter("api_call_count_total", "endpoint", "/api/test");
    }
    @GetMapping("/test")
    public String test() {
        myApiCounter.increment();
        return "value";
    }
}
