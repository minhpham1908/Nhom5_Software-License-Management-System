FROM openjdk:11.0.9
COPY ./server/src /usr/server/src
COPY ./RMIService/src /usr/server/src
WORKDIR /usr/server/src
RUN javac -d /usr/server/out -cp /usr/server/src yuhnim/server/*.java
WORKDIR /usr/server/out
CMD ["java", "yuhnim.server.Server"]
