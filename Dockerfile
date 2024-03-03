FROM openjdk:18
WORKDIR /usr/src/myapp
COPY target/*.jar /usr/src/myapp
EXPOSE 9030
CMD ["java", "-jar", "blog-service-0.0.1-SNAPSHOT.jar"]