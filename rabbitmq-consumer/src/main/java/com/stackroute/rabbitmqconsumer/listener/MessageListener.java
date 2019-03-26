package com.stackroute.rabbitmqconsumer.listener;

public interface MessageListener {
    public void onMessage(String message);
}
