FROM adoptopenjdk/openjdk11

WORKDIR /app
COPY ./target/attachment-processing.jar .

ENTRYPOINT ["java", "-jar", "attachment-processing.jar"]
