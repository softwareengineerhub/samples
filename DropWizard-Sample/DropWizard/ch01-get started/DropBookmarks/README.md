# DropBookmarks
Creation of project:
1) io.dropwizard.archetypes:java-simple:0.8.2
2) Add name property:
name=DropBookmarks

How to start the DropBookmarks application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/DropBookmarks-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
