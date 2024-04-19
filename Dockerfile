FROM openjdk:8-jdk-alpine

VOLUME /tmp
EXPOSE 8080
#ARG JAR_FILE=target/Docker-ejemplo-0.0.1-SNAPSHOT.jar

#LABEL author=root.
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]