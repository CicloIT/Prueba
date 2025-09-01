# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-jammy

# Directorio de la app
WORKDIR /app

# Copiamos el JAR ya compilado (build local)
COPY target/game-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto
EXPOSE 8080

# Comando para correr la app
ENTRYPOINT ["java", "-jar", "app.jar"]
