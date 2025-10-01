FROM maven:3.9.9-amazoncorretto-21-al2023 AS builder
WORKDIR /app

COPY notificacao-service/pom.xml .
COPY notificacao-service/src ./src
RUN mvn clean package -DskipTests -Pdocker

FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]
