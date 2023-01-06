# API INTERVIEW
 Mobile Food Facility - API that returns a set of food trucks

## Database
It uses a H2 in-memory database sqlite database (for easy local test without losing test data after every restart), can be changed easily in the application.yml for any other database.
```
http://localhost:8080/h2-console/
userName: sa
password:
```

## OpenAPI & Swagger
OpenAPI Specification (formerly Swagger Specification) is an API description format for REST APIs. An OpenAPI file allows you to describe your entire API

Swagger is a set of open-source tools built around the OpenAPI Specification that can help you design, build, document and consume REST APIs
```
swagger.json: http://localhost:8080/v2/api-docs

swagger-ui: http://localhost:8080/swagger-ui.html
```

## Dependencies

This project uses Maven for builds.
You need Java 11 installed.
You can use Intellij to open the project and run it.


## Building

```
$ mvn clean install
```

## Running

```
$ java -jar target/api_interview_eoc-0.0.1-SNAPSHOT.jar
```

## Call Endpoints

```
Import the json file('mobileFood.postman_collection.json') on the Postman application to call the endpoints
```

## Testing

```
$ mvn test
```


