# define base docker image
FROM openjdk:8
LABEL maintainer="BackEnd App"
ADD target\fullstack-backend-0.0.1-SNAPSHOT.jar springboot-docker-backend.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-backend.jar"]
