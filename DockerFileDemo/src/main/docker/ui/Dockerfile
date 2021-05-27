FROM java:8-jdk-alpine

COPY ./target/DockerFileDemo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch DockerFileDemo-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","DockerFileDemo-0.0.1-SNAPSHOT.jar"]