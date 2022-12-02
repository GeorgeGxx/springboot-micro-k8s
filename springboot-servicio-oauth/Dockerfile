#
# Build stage
#
ARG MSVC_NAME=springboot-servicio-Oauth
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
COPY --from=builder $TARGET_FOLDER/springboot-servicio-oauth-0.0.1-SNAPSHOT.jar /usr/local/lib/servicio-oauth.jar
EXPOSE 9100
ENTRYPOINT ["java","-jar","/usr/local/lib/servicio-oauth.jar"]


#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 9100
#ADD ./target/springboot-servicio-oauth-0.0.1-SNAPSHOT.jar servicio-oauth.jar
#ENTRYPOINT ["java","-jar","/servicio-oauth.jar"]