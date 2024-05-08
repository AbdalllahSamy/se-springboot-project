FROM openjdk:17-jdk-alpine

COPY target/spring-boot-docker.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]
