
FROM gradle:8.2.1-jdk17 AS build
WORKDIR /app
COPY . /app
RUN gradle clean build -x test

FROM openjdk:17-jdk-slim-buster
COPY build/libs/powerplant-0.0.1-SNAPSHOT.jar powerplant.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "powerplant.jar"]