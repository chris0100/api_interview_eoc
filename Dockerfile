FROM alpine:latest as build
WORKDIR /opt/api_interview_eoc
COPY . .
RUN apk update \
    && apk add maven \
    && mvn clean install -DskipTests

FROM adoptopenjdk/openjdk11:latest
COPY --from=build /opt/api_interview_eoc/target/api_interview_eoc-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
