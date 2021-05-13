FROM ubuntu:latest

MAINTAINER Klaudia Pilszak "klaudia.pilszak@gmail.com"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/

ADD simple-service.jar .

ENTRYPOINT ["java", "-jar", "simple-service.jar"]