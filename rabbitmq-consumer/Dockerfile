FROM openjdk:11

ADD ./target/rabbitmq-consumer-0.0.1-SNAPSHOT.jar /usr/src/rabbitmq-consumer-0.0.1-SNAPSHOT.jar


WORKDIR usr/src

ENTRYPOINT ["java","-jar", "rabbitmq-consumer-0.0.1-SNAPSHOT.jar"]