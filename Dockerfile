
# Usar la imagen base de OpenJDK 17
FROM openjdk:17

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Maven al contenedor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exponer el puerto 8080
EXPOSE 8080
