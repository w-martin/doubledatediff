FROM public.ecr.aws/amazoncorretto/amazoncorretto:21

COPY target/datediff-1.0-SNAPSHOT.jar server.jar

ENTRYPOINT ["java", "-jar", "server.jar"]
