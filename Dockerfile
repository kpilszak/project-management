FROM ubuntu:latest

MAINTAINER Klaudia Pilszak "klaudia.pilszak@gmail.com"

RUN apt-get update && apt-get install -y openjdk-8-jdk

ENV version=docker

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
