# Running tests

To run tests, run:
```shell
mvn test
```

To generate a test coverage report, run:
```shell
mvn clean test jacoco:report
```

# Running the application

## To update mvnw script
```sh
mvn -N io.takari:maven:wrapper
```

## Running locally

To run locally, please install java 21.
Then, run
```shell
./mvnw spring-boot:run
```

## Running in docker

To build the docker image, run:
```shell
mvn clean package
docker build -t spring-boot-docker .
```

Then, to run the docker image, run:
```shell
docker run -p 8080:8080 spring-boot-docker
```

A collection of sample requests is included in http format.

(Optional) To install IntelliJ IDEA HTTP Client, run:
```shell
curl -f -L -o ijhttp.zip "https://jb.gg/ijhttp/latest" && unzip -q ijhttp.zip && rm ijhttp.zip
```

Verify the deployment by running sample requests:
```shell
./ijhttp/ijhttp sample-requests.http
```
