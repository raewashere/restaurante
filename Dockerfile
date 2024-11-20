# Usar la imagen base de OpenJDK 17
FROM openjdk:17

# Copiar el archivo JAR generado por Spring Boot a la raíz del contenedor
COPY target/restaurante-1.0.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Exponer el puerto 8080
EXPOSE 8080
