FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/solution-0.0.1-SNAPSHOT.jar
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]