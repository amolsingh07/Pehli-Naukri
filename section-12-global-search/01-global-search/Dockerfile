# Use Java 22 runtime image
FROM openjdk:22-jdk

# Set working directory
WORKDIR /app

# Copy project JAR (assuming you build it later)
COPY target/*.jar app.jar

# Expose port
EXPOSE 8080

# Command to run app
ENTRYPOINT ["java", "-jar", "app.jar"]

