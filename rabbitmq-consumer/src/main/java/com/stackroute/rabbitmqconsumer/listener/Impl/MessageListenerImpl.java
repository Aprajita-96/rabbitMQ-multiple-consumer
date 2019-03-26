package com.stackroute.rabbitmqconsumer.listener.Impl;

import com.stackroute.rabbitmqconsumer.listener.MessageListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListenerImpl implements MessageListener {

    /**
     * onMessage() will print the message on console
     * @param message message from the producer
     */
    @Override
    public void onMessage(String message) {

        System.out.println("Message Received:"+message);

    }
}
