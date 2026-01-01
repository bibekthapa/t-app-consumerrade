FROM eclipse-temurin:21-jdk-alpine

ARG JAR_FILE=target/consumer*.jar
COPY ${JAR_FILE} consumerapp.jar
ENTRYPOINT [ "java", "-jar" , "/consumerapp.jar" ]
EXPOSE 8082
