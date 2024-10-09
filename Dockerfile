FROM openjdk:11
VOLUME /tmp
RUN mkdir /application
COPY . /application
WORKDIR /application
RUN mv /application/target/*.jar /application/ms-keolatest.jar

# Exponer el puerto en el que tu aplicación se ejecuta
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/application/ms-keolatest.jar"]