#
# Build stage
#
FROM maven:3.8.8-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the project without running tests
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/CreditCard_TokenProject-0.0.1-SNAPSHOT.jar demo.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]
