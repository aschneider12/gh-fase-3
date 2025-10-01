# Para subir o container do projeto use o comando abaixo
# $ docker build -t postech/spring-gh:<tag_de_versao> .

#Neste momento usamos o maven
FROM maven:3.9.9-amazoncorretto-21-al2023 AS builder
#Define a pasta de trabalho como /app
WORKDIR /app

# Copia os projetos de dependência para o build
COPY jpa /app/jpa
COPY security /app/security

# Instala os JARs no repositório local do Maven
RUN mvn -f jpa/pom.xml clean install && \
    mvn -f security/pom.xml clean install
    
#CopSia os arquivos para a pasta de trabalho .
COPY agendamento-service/pom.xml .
COPY  agendamento-service/src ./src

RUN mvn clean package -DskipTests

# Fase de rodar o projeto
FROM openjdk:21-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar ghospital.jar

# demonstra que o container irá expor a porta 8080, alinhado com a configuração do projeto Spring
EXPOSE 8080

ENTRYPOINT ["java","-jar","ghospital.jar"]
