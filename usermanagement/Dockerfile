# Usa immagine base con JDK 21 (compatibile con Spring Boot)
FROM eclipse-temurin:21-jdk

# Imposta la working directory
WORKDIR /app

# Copia il jar buildato da Maven
COPY target/*.jar app.jar

# Espone la porta Spring Boot (di default 8080)
EXPOSE 8081

# Comando di avvio
ENTRYPOINT ["java", "-jar", "app.jar"]
