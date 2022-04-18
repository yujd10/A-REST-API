# define base docker image
FROM openjdk:8
LABEL maintainer = "jd.net"
ADD target/rest-0.0.1-SNAPSHOT.jar springboot-docker-rest.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-rest.jar"]