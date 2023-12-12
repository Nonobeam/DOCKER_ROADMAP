# FROM maven:4.0.0-jdk-11 # for Java 11
FROM maven:3.8.1-openjdk-17

WORKDIR /demo
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run