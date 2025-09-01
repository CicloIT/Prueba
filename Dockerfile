# Imagen base con Java 17 y Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos pom y descargamos dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# Segunda etapa: imagen más ligera solo con JAR y JDK
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/game-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
