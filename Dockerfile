FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080
COPY ./target/PiEvent-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]