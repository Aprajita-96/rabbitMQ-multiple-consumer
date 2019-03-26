package com.stackroute.rabbitmqproducer.controller;

import com.stackroute.rabbitmqproducer.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    //Entity Autowiring of MessageProducer
    @Autowired
    private MessageProducer messageProducer;

    /**
     * Rest Endpoints for first Consumer
     * @param message we will get it from POSTMAN
     * @return message to POSTMAN
     */
    @GetMapping("/consumer")
    public String produceForConsumer(@RequestParam String message) {
        messageProducer.sendMessage(message);
        return "message send to RabbitMq and the message is " + message;

    }

    /**
     * Rest Endpoints for second Consumer
     * @param message we will get it from POSTMAN
     * @return message to POSTMAN
     */
    @GetMapping("/consumer2")
    public String produceForConsumer2(@RequestParam String message) {
        messageProducer.sendMessage2(message);
        return "message send to RabbitMq and the message is " + message;

    }

    /**
     * Rest Endpoints for third Consumer
     * @param message we will get it from POSTMAN
     * @return message to POSTMAN
     */
    @GetMapping("/consumer3")
    public String produceForConsumer3(@RequestParam String message) {
        messageProducer.sendMessage3(message);
        return "message send to RabbitMq and the message is " + message;

    }
}
