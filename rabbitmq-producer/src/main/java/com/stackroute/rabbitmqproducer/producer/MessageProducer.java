package com.stackroute.rabbitmqproducer.producer;

import com.stackroute.rabbitmqproducer.config.RobbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageProducer {

    /*
        Autowiring RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //logger for logs
    private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);

    /*
     RabbitTemplate is used to convert and send a message using RabbitMQ.
     It is a helper class, as many other Template classes existing in Spring
     (such as JdbcTemplate , RestTemplate , etc.).
     */

    /**
     * sendMessage() method will send the messages to exchange with routing key
     *
     * @param message we will get it from POSTMAN
     */
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RobbitMqConfig.EXCHANGE_NAME, RobbitMqConfig.ROUTING_FIRST_KEY, message);
        System.out.println("Is listener returned ::: " + rabbitTemplate.isReturnListener());
        log.info("message has been produced");
    }

    /**
     * sendMessage2() method will send the messages to exchange with routing key
     *
     * @param message we will get it from POSTMAN
     */
    public void sendMessage2(String message) {
        rabbitTemplate.convertAndSend(RobbitMqConfig.EXCHANGE_NAME, RobbitMqConfig.ROUTING_SECOND_KEY, message);
        System.out.println("Is listener returned ::: " + rabbitTemplate.isReturnListener());
        log.info("message has been produced");
    }

    /**
     * sendMessage3() method will send the messages to exchange with routing key
     *
     * @param message we will get it from POSTMAN
     */
    public void sendMessage3(String message) {
        rabbitTemplate.convertAndSend(RobbitMqConfig.EXCHANGE_NAME, RobbitMqConfig.ROUTING_THIRD_KEY, message);
        System.out.println("Is listener returned ::: " + rabbitTemplate.isReturnListener());
        log.info("message has been produced");
    }
}
