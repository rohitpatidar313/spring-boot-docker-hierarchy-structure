FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD target/structure-0.0.1-SNAPSHOT.jar structure-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","structure-0.0.1-SNAPSHOT.jar"]