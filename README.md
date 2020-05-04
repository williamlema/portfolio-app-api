# Portfolio App Api

This is a simple API application with Spring Boot and add some useful services to connect with database and Twitter API.

## Requirements

For building and running the application you need:

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Gradle 4+](http://www.gradle.org/downloads)

### Configuration

For running and deploy the application you need to set the following properties over `application.properties`.

* spring.datasource.url
* spring.datasource.username
* spring.datasource.password

* config.twitter.appKey
* config.twitter.appSecretKey
* config.twitter.access.token
* config.twitter.access.token.secret

NOTE: You can replace the entire value or just replace `<UnCoverValue>` tag with the respective value

### Used libraries

This application use the following libraries

* [spring-boot-starter](https://spring.io/guides/gs/spring-boot/): From spring boot is used libraries like starter-web, starter-jpa and starter-data-rest
* [org.twitter4j](http://twitter4j.org/en/): To intergrate Twitter API.
* [org.mockito](https://site.mockito.org/): To support unit test


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the following command in root directory

```
$ gradle build && java -jar build/libs/portfolio-api-1.0-SNAPSHOT.jar

```


## Build and deploy with Docker

### Prerequisites

#### Docker

Docker and Docker Compose are used to build and deploy this application,.

Installation instructions for Docker can be found on its [Get Started](https://docs.docker.com/get-started/) page.

If your installation of Docker did not come with Docker Compose, you can follow its
[install instructions](https://docs.docker.com/compose/install/).

### Running

To start the Portfolio App Api run the following command over root folder:

```
$ docker-compose up
```

If you apply any change over code run the following commands to refresh image and container:

```
$ docker-compose build
$ docker-compose up
```

The Api will run over http://localhost:5000/, to test the api you can use the postman file `portfolio-api-test.postman_collection.json` in `resources` folder

