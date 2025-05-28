package com.example.demo;

//import com.example.demo.monitor.MonitorCounter;
//import com.example.demo.monitor.MonitorTimer;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiPerformaceApplication {
	@Bean
	public MeterRegistry meterRegistry() {
		return new SimpleMeterRegistry();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiPerformaceApplication.class, args);
	}
//
//	@Bean
//	public MonitorCounter monitorCounter() {
//		String name = "request_counter";
//		String description = "Counter for incoming request to APIs";
//		String method = "Method";
//		String url = "URL";
//		String statusCode = "Code";
//		String[] tags = new String[]{method, url, statusCode};
//		return new MonitorCounter(name, description, meterRegistry, tags);
//	}
//	@Bean
//	public MonitorTimer monitorTimer() {
//		String name = "response_duration_seconds";
//		String description = "Duration range  for response to api call";
//		String method = "Method";
//		String url = "URL";
//		String statusCode = "Code";
//		String[] tags = new String[]{method, url, statusCode};
//		return new MonitorTimer(name, description, meterRegistry, tags);
//	}
}
