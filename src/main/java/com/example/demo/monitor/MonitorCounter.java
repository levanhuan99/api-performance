//package com.example.demo.monitor;
//
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.ImmutableTag;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.Tag;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Component
//public class MonitorCounter {
//
//    private final String name;
//    private final String description;
//    private final String[] tagNames;
//    private final Map<String, Counter> counterMap = new ConcurrentHashMap<>();
//
//    private final MeterRegistry registry;
//
//    public MonitorCounter(String name, String description, MeterRegistry meterRegistry, String[] tagNames) {
//        this.name = name;
//        this.description = description;
//        this.registry = meterRegistry;
//        this.tagNames = tagNames;
//    }
//    public void increment(String ... tagValues) {
//        String valuesString = Arrays.toString(tagValues);
//        if(tagValues.length != tagNames.length) {
//            System.out.println("Illigal exception");
//        }
//        Counter counter = counterMap.get(valuesString);
//        if(counter == null) {
//            List<Tag> tags = new ArrayList<>(tagNames.length);
//            for(int i = 0; i<tagNames.length; i++) {
//                tags.add(new ImmutableTag(tagNames[i], tagValues[i]));
//            }
//            counter = Counter.builder(name).tags(tags)
//                    .description(description).register(registry);
//            counterMap.put(valuesString, counter);
//        }
//        counter.increment();
//    }
//}
