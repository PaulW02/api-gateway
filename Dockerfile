# Use an official OpenJDK runtime as a parent image
FROM openjdk:18

WORKDIR /app


COPY .mvn/ .mvn
COPY mvnw pom.xml ./
USER root
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 5005

CMD ["./mvnw", "spring-boot:run"]