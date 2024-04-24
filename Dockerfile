FROM openjdk:17-jdk-alpine

COPY build/libs/sudoku-app-0.0.1-SNAPSHOT.jar sudoku-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "sudoku-app.jar"]