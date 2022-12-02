#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/springboot-servicio-commons/src
COPY pom.xml /home/springboot-servicio-commons
RUN mvn -f /home/springboot-servicio-commons/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/springboot-servicio-commons/target/springboot-servicio-commons-0.0.1-SNAPSHOT.jar /usr/local/lib/servicio-commons.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/servicio-commons.jar"]