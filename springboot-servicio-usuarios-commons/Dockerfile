#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/springboot-servicio-usuarios-commons/src
COPY pom.xml /home/springboot-servicio-usuarios-commons
RUN mvn -f /home/springboot-servicio-usuarios-commons/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/springboot-servicio-usuarios-commons/target/springboot-servicio-usuarios-commons-0.0.1-SNAPSHOT.jar /usr/local/lib/usuarios-commons.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/usuarios-commons.jar"]