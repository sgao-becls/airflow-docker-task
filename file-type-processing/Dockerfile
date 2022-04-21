FROM adoptopenjdk/openjdk11

WORKDIR /app
COPY ./target/file-type-processing.jar .

ENTRYPOINT ["java", "-jar", "file-type-processing.jar"]
