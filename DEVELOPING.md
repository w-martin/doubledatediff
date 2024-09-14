## To update mvnw script
```sh
mvn -N io.takari:maven:wrapper
```

# Running locally

To run locally, please install java 21.
Then, run
```shell
./mvnw spring-boot:run
```

# Running in docker

To build the docker image, run:
```shell
mvn clean package
docker build -t spring-boot-docker .
```

Then, to run the docker image, run:
```shell
docker run -p 8080:8080 spring-boot-docker
```