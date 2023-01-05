# API INTERVIEW
 Mobile Food Facility - API that returns a set of food trucks

## Database
It uses a H2 in-memory database sqlite database (for easy local test without losing test data after every restart), can be changed easily in the application.yml for any other database.

## Dependencies

This project uses Maven for builds.
You need Java 11 installed.


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


