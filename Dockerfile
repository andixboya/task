# requires execution of build-docker.sh
# otherwise it will not find the build .jar
FROM openjdk:11
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
