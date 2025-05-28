//package com.example.demo.monitor;
//
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.Timer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class MonitorMetric {
//
//    // this counter is standing for count number of request to application
//    private Counter requestCounter;
//    private Map<Integer, Counter> requestCounterMap;
//
//    // this timer is standing for processing time from input request to api util repose to client
//    private Timer responseTimer;
//
//    @Autowired
//    private MeterRegistry meterRegistry;
//
//    public MonitorMetric() {
//
//    }
//
//    public void increaseCounterMap(String... values) {
//        if (requestCounterMap == null) {
//            requestCounterMap = new ConcurrentHashMap<>();
//        }
//        Counter counter = requestCounterMap.get(values.length);
//        if (counter == null) {
//            counter = Counter.builder("requests_total_map")
//                    .description("Total number of requests")
//                    .tags(values)
//                    .register(meterRegistry);
//            requestCounterMap.put(values.length, counter);
//        }
//        counter.increment();
//    }
//
//    // parameters are tags of counter
//    public void increaseRequestCounter(String... values) {
//        if (this.requestCounter == null) {
//            this.requestCounter = Counter.builder("requests_total")
//                    .description("Total number of requests")
//                    .tags(values)
//                    .register(meterRegistry);
//        }
//        this.requestCounter.increment();
//    }
//    public void recordRequestApiTimer(long millisecond, String... values) {
//        if (this.responseTimer == null) {
//            this.responseTimer = Timer.builder("response_duration_seconds")
//                    .description("Seconds response duration of api requests")
//                    .tags(values)
//                    .publishPercentiles(0.2, 0.5, 0.7, 0.9)
//                    .register(this.meterRegistry);
//        }
//        this.responseTimer.record(millisecond, TimeUnit.MILLISECONDS);
//    }
//
//}
