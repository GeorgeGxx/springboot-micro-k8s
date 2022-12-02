#
# Build stage
#
ARG MSVC_NAME=springboot-servicio-item
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
COPY --from=builder $TARGET_FOLDER/springboot-servicio-item-0.0.1-SNAPSHOT.jar /usr/local/lib/servicio-item.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","/usr/local/lib/servicio-item.jar"]


#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8002
#ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar servicio-item.jar
#ENTRYPOINT ["java","-jar","/servicio-item.jar"]