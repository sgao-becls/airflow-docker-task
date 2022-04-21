FROM adoptopenjdk/openjdk11

WORKDIR /app
COPY ./target/fcs-file-processing.jar .

ENTRYPOINT ["java", "-jar", "fcs-file-processing.jar"]
