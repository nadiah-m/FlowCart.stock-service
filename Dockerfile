FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your target directory
COPY target/stock-service-0.0.1-SNAPSHOT.jar stock-service.jar

# Expose port 8080 (default Spring Boot port)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/stock-service.jar"]