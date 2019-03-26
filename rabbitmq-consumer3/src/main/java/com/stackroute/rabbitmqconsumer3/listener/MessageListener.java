package com.stackroute.rabbitmqconsumer3.listener;

public interface MessageListener {
    public void onMessage(String message);
}
