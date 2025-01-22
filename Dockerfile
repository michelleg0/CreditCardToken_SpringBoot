# Use OpenJDK 17 as the base image
FROM openjdk:21-jdk-slim
# Set the working directory
WORKDIR /app
# Copy the compiled JAR file from your project into the Docker container
COPY target/*.jar app.jar
# Expose the port your app will run on (Spring Boot default is 8080)
EXPOSE 8080
# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]