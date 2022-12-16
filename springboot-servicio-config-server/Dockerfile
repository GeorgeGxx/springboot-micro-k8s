#
# Build stage
#
ARG MSVC_NAME=springboot-servicio-config-server
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
COPY --from=builder $TARGET_FOLDER/springboot-servicio-config-server-0.0.1-SNAPSHOT.jar /usr/local/lib/config-server.jar
ARG PORT_APP=8888
ENV PORT $PORT_APP
EXPOSE $PORT
ENTRYPOINT ["java","-jar","/usr/local/lib/config-server.jar"]


#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8888
#ADD ./target/springboot-servicio-config-server-0.0.1-SNAPSHOT.jar config-server.jar
#ENTRYPOINT ["java","-jar","/config-server.jar"]