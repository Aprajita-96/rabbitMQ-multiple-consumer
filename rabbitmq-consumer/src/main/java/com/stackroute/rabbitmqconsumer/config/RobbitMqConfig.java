package com.stackroute.rabbitmqconsumer.config;

import com.stackroute.rabbitmqconsumer.listener.MessageListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobbitMqConfig {

    // Binding key for first consumer
    public static final String BINDING_KEY = "my.routing1.key";

    //Name of Exchange
    public static final String EXCHANGE_NAME = "my.exchange.topic";

    //Queue name for first queue
    public static final String QUEUE_NAME = "my.queue1.name";


    /**
     * Creating a bean for first queue
     *
     * @return queue
     */
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    /**
     * exchange() method
     *
     * @return the TopicExchange
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * binding() method will bind the first queue to topic exchange with
     * binding key attribute for first consumer
     *
     * @return Binding
     */
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(BINDING_KEY);
    }


    /**
     *  we will register a Receiver with the message listener container to receive messages.
     *
     * @param connectionFactory drives both, allowing them to connect to the RabbitMQ server.
     * @param listenerAdapter Message listener adapter that delegates the handling of messages
     * to target listener methods via reflection, with flexible message type conversion.
     * Allows listener methods to operate on message content types, completely independent from
     * the JMS API.
     * @return SimpleMessageListenerContainer
     */
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }


    /**
     * myQueueListener() will listen the message and give it to onMesage() method
     * @param listener it is a MessageListener
     * @return MessageListenerAdapter
     */
    @Bean
    MessageListenerAdapter myQueueListener(MessageListener listener) {
        return new MessageListenerAdapter(listener, "onMessage");
    }
}
