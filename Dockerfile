FROM openjdk:8-jre-alpine

RUN mkdir /app

COPY ./target/Storitev-1.0.jar /app/

CMD ["java", "-jar", "/app/Storitev-1.0.jar"]
