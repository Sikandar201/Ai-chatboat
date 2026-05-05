FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/devops_project-0.0.1-SNAPSHOT.war app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
