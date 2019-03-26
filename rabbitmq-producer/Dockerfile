FROM openjdk:11

ADD ./target/rabbitmq-producer-0.0.1-SNAPSHOT.jar /usr/src/rabbitmq-producer-0.0.1-SNAPSHOT.jar


WORKDIR usr/src

ENTRYPOINT ["java","-jar", "rabbitmq-producer-0.0.1-SNAPSHOT.jar"]