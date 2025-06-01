# API Performance Monitoring Project

This project demonstrates API performance monitoring and metrics collection using Spring Boot, Spring Actuator, and Prometheus integration.

## Project Overview
- Built with Spring Boot 3.5.0
- API performance monitoring and metrics collection
- Logging system with Log4j2
- Prometheus metrics integration
- Spring Actuator for application monitoring

## Requirements
- Java 24
- Maven 3.x
- Docker (optional, for running Prometheus)

## Setup and Installation

### 1. Clone the Repository
```bash
git clone [repository-url]
cd api-performance
```

### 2. Build the Project
```bash
./mvnw clean install
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```

The application will start on port 8080 by default.

## Key Features

### 1. Spring Actuator Endpoints
- Health check: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/metrics`
- Prometheus: `http://localhost:8080/actuator/prometheus`

### 2. Performance Monitoring
- API response time metrics
- JVM metrics
- System metrics
- Custom business metrics

### 3. Logging
- Console and file-based logging
- Configurable log levels
- Rolling file strategy

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── log4j2.xml
```

## Dependencies
- spring-boot-starter-web
- spring-boot-starter-actuator
- micrometer-registry-prometheus
- spring-boot-starter-log4j2

## Configuration
The application can be configured through `application.properties`:
```properties
# Server configuration
server.port=8080

# Actuator configuration
management.endpoints.web.exposure.include=health,metrics,prometheus
management.endpoint.health.show-details=always
```

## Monitoring Setup
1. Access metrics via Actuator endpoints
2. View detailed health information
3. Monitor performance metrics through Prometheus integration

## Support and Documentation
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Actuator Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Prometheus Documentation](https://prometheus.io/docs/introduction/overview/)

## Build and Run

### Build Project with Dependencies
```bash
# Clean and package the application
./mvnw clean package

# This will create the following structure in ./output directory:
output/
├── lib/            # All dependency JARs
├── config/         # Configuration files
│   ├── application.properties
│   └── log4j2.xml
└── demo-0.0.1-SNAPSHOT.jar  # Application JAR
```

### Run the Application
You can run the application in two ways:

1. Using the provided script:
```bash
# Make the script executable
chmod +x run.sh

# Run the application
./run.sh
```

2. Manually:
```bash
# Get the JAR file name
JAR_FILE=$(ls output/*.jar | grep -v 'original')

# Run the application
java -cp "output/lib/*:$JAR_FILE" \
     -Dspring.config.location=output/config/application.properties \
     -Dlogging.config=output/config/log4j2.xml \
     com.example.demo.ApiPerformaceApplication
```

The application will start on port 8080 by default.
