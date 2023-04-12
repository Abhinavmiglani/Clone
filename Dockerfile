# define base docker image
FROM openjdk:8-jdk
RUN addgroup --system spring && adduser --system spring -ingroup spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springboot-docker-backend.jar
ENTRYPOINT ["java","-jar","/springboot-docker-backend.jar"]
