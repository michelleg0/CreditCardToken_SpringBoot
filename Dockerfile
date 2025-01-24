#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
# Use OpenJDK 21 as the base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file from your project into the Docker container
COPY target/CreditCard_TokenProject-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app will run on (Spring Boot default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar", "CreditCard_TokenProject"]