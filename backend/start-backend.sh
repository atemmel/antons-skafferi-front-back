#!/bin/sh
# Kill previous instance
killall java
# Build .jar file
mvn install
# Run .jar file
java -jar target/restful-web-services-0.0.1-SNAPSHOT.jar
