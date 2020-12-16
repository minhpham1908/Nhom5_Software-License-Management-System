FROM openjdk:11.0.9-jre
COPY ./out/artifacts /usr/client
WORKDIR /usr/client/webserver_jar
CMD ["java","-jar","webserver.jar"]