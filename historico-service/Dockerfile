# Etapa de build
FROM maven:3.9.9-amazoncorretto-21-al2023 AS builder
WORKDIR /app

# Copia os projetos de dependência para o build
COPY jpa /app/jpa
COPY security /app/security

# Instala os JARs no repositório local do Maven
RUN mvn -f jpa/pom.xml clean install && \
    mvn -f security/pom.xml clean install

# Copia o projeto atual
COPY historico-service/pom.xml .
COPY historico-service/src ./src

# Compila o serviço
RUN mvn clean package -DskipTests -Pdocker

# Etapa de runtime
FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]

