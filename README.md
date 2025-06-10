# Spring Cloud Demo

This is a demo project showcasing Spring Cloud core features, including:

1. Eureka Server (Service Registry)
2. Config Server (Configuration Management)
3. API Gateway (Gateway Service)
4. Service Provider
5. Service Consumer

## Project Structure

```
spring-cloud-demo/
├── eureka-server/          # Service Registry
├── config-server/          # Configuration Server
├── spring-cloud-demo-config/  # Configuration Repository (GitHub: fantianopensource/spring-cloud-demo-config)
├── api-gateway/            # API Gateway Service
├── service-provider/       # Service Provider
└── service-consumer/       # Service Consumer
```

## Technology Stack

- Spring Boot 3.2.3
- Spring Cloud 2023.0.0
- Spring Cloud Netflix Eureka
- Spring Cloud Config
- Spring Cloud Gateway
- Spring Cloud OpenFeign
- Java 17

## How to Run

1. Start Eureka Server (First, as it's the service registry):

```bash
cd eureka-server
mvn spring-boot:run
```

Visit http://localhost:8761 to access Eureka Dashboard

2. Start Config Server (Second, as services depend on it for configuration):

```bash
cd config-server
mvn spring-boot:run
```

3. Start Service Provider (Third, as it's a basic service):

```bash
cd service-provider
mvn spring-boot:run
```

4. Start Service Consumer (Fourth, as it depends on Service Provider):

```bash
cd service-consumer
mvn spring-boot:run
```

5. Start API Gateway (Last, as it depends on all other services):

```bash
cd api-gateway
mvn spring-boot:run
```

## Test Services

1. Access Service Provider:

```bash
curl http://localhost:8081/api/hello
```

2. Access Service Consumer:

```bash
curl http://localhost:8082/api/consumer/hello
```

3. Access through API Gateway:

```bash
# Access service-consumer through gateway
curl http://localhost:8080/api/consumer/hello
```

## Features

1. Service Registration and Discovery

   - Service provider and consumer automatically register with Eureka Server
   - View registered services through Eureka Dashboard

2. Configuration Management

   - Centralized configuration using Spring Cloud Config
   - Configuration files stored in spring-cloud-demo-config (GitHub: fantianopensource/spring-cloud-demo-config)
   - Dynamic configuration updates

3. API Gateway

   - Route requests to appropriate services
   - Load balancing
   - Request/Response transformation
   - Cross-cutting concerns (security, monitoring)

4. Service Invocation

   - Service consumer calls provider using OpenFeign
   - Implements declarative REST client

5. Load Balancing
   - Default client-side load balancing with Ribbon
   - Test by starting multiple service provider instances

## Configuration Repository

The `spring-cloud-demo-config` directory is maintained as a separate Git repository to store configuration files for different services. This follows the best practice of separating configuration from code.

### Setting up spring-cloud-demo-config

Since `spring-cloud-demo-config` is a separate repository, you need to clone it manually:

1. Clone the configuration repository:

```bash
git clone git@github.com:fantianopensource/spring-cloud-demo-config.git
```

2. Create configuration files for each service (except eureka-server):

```bash
# Example structure
spring-cloud-demo-config/
├── service-provider.yml
├── service-consumer.yml
└── api-gateway.yml
```

Note: Eureka Server configuration is not included in spring-cloud-demo-config because Eureka Server must be started before Config Server, and Config Server needs to be running to serve configurations from spring-cloud-demo-config.

3. Add your configuration files to git:

```bash
git add .
git commit -m "Initial configuration files"
```

Note: Make sure to keep your spring-cloud-demo-config in a secure location and manage it separately from the main project.

## Notes

- Ensure all services are properly started in the correct order:
  1. Eureka Server (port 8761) - MUST be started first
  2. Config Server (port 8888) - Depends on Eureka Server
  3. Service Provider (port 8081) - Depends on Config Server and Eureka Server
  4. Service Consumer (port 8082) - Depends on Config Server and Eureka Server
  5. API Gateway (port 8080) - Depends on Config Server and Eureka Server
- Check if ports are available
- Monitor Eureka Dashboard to confirm service registration
- Configuration changes in spring-cloud-demo-config will be automatically picked up by services
- API Gateway provides a unified entry point for all services
