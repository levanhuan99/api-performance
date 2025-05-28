package com.example.demo.monitor;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//
//import io.micrometer.core.instrument.ImmutableTag;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.Tag;
//import io.micrometer.core.instrument.Timer;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//
//@Component
public class MonitorTimer {
    private static final int TARGET_TPS = 100;
    private static final int TEST_DURATION_SECONDS = 30000;
    private static final String API_URL = "http://localhost:8080/api/test";

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(TARGET_TPS);

        Runnable sendRequest = () -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                System.out.println("Response: " + responseCode);
                connection.disconnect();
            } catch (Exception e) {
                System.err.println("Error sending request: " + e.getMessage());
            }
        };

        long period = 1000L / TARGET_TPS; // milliseconds between requests per thread

        for (int i = 0; i < TARGET_TPS; i++) {
            scheduler.scheduleAtFixedRate(sendRequest, i * period, 1000, TimeUnit.MILLISECONDS);
        }

        // Stop after the test duration
        scheduler.schedule(() -> {
            System.out.println("Stopping after " + TEST_DURATION_SECONDS + " seconds.");
            scheduler.shutdown();
        }, TEST_DURATION_SECONDS, TimeUnit.SECONDS);
    }
}
//    private final String name;
//    private final String description;
//    private final String[] tagNames;
//    private final MeterRegistry registry;
//    private final Map<String, Timer> timerMap = new ConcurrentHashMap<>();
//
//    public MonitorTimer(String name, String description, MeterRegistry registry, String[] tagNames) {
//        this.name = name;
//        this.description = description;
//        this.tagNames = tagNames;
//        this.registry = registry;
//    }
//    public void record(long millisecond, String... values) {
//        String valuesString = Arrays.toString(values);
//        if( tagNames.length != values.length) {
//            System.out.println("Counter tags mismatch! Expected args ");
//        }
//        Timer timer = timerMap.get(valuesString);
//        if (timer == null) {
//            List<Tag> tags = new ArrayList<>();
//            for (int i = 0; i < values.length; i++) {
//                tags.add(new ImmutableTag(tagNames[i], values[i]));
//            }
//            timer = Timer.builder(this.name)
//                    .description(this.description)
//                    .tags(tags)
//                    .publishPercentiles(0.2, 0.5, 0.7, 0.9)
//                    .register(this.registry);
//            timerMap.put(valuesString, timer);
//        }
//        timer.record(millisecond, TimeUnit.MILLISECONDS);
//    }
//}
