FROM openjdk:11-jdk as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests


FROM openjdk:11-jdk

RUN adduser --system sg
USER sg

WORKDIR /home/sg

RUN mkdir config

VOLUME /tmp

ARG JAR_FILE=/workspace/app/target/sendgrid*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /home/sg/app.jar --spring.profiles.active=prod"]