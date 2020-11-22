FROM openjdk:11.0.9
COPY . /usr/src/server
WORKDIR /usr/src/server
RUN javac Server.java
CMD ["java","Server"]