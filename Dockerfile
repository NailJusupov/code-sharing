FROM java:8
ADD target/codesharing.jar codesharing.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "codesharing.jar"]
