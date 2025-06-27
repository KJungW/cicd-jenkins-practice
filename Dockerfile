FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY build/libs/jenkins-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
