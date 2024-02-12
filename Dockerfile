FROM openjdk:17-oracle
EXPOSE 8080
ARG JAR_FILE=/target/axelapi-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]