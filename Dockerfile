FROM maven:3.8.1-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/*.jar eLibrary-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","eLibrary-1.0.0.jar"]