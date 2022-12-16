#
# Build stage
#
ARG MSVC_NAME=springboot-servicio-zuul-server
FROM maven:3.6.0-jdk-11-slim AS builder
ARG MSVC_NAME
WORKDIR /app/$MSVC_NAME
COPY pom.xml .
COPY src ./src
RUN mvn -f pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
ARG MSVC_NAME
WORKDIR /app
#RUN mkdir ./logs
ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/springboot-servicio-zuul-server-0.0.1-SNAPSHOT.jar /usr/local/lib/zuul-server.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/zuul-server.jar"]


#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8090
#ADD ./target/springboot-servicio-zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar
#ENTRYPOINT ["java","-jar","/zuul-server.jar"]