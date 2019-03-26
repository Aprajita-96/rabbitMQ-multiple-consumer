package com.stackroute.rabbitmqproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobbitMqConfig {


    /*
    The routing key is a message attribute. The exchange might
    look at this key when deciding how to route the message to queues
    (depending on exchange type).
     */

    //Routing key attribute for first consumer
    public static final String ROUTING_FIRST_KEY = "my.routing1.key";

    //Routing key attribute for second consumer
    public static final String ROUTING_SECOND_KEY = "my.routing2.key";

    //Routing key attribute for third consumer
    public static final String ROUTING_THIRD_KEY = "my.routing3.key";

    //Name of Exchange
    public static final String EXCHANGE_NAME = "my.exchange.topic";

    //Queue name for first queue
    public static final String QUEUE_FIRST_NAME = "my.queue1.name";

    //Queue name for second queue
    public static final String QUEUE_SECOND_NAME = "my.queue2.name";

    //Queue name for third queue
    public static final String QUEUE_THIRD_NAME = "my.queue3.name";

    /*
    Exchanges, connections, and queues can be configured with parameters such as durable,
    temporary, and auto delete upon creation. Durable exchanges survive server restarts
    and last until they are explicitly deleted. Temporary exchanges exist until RabbitMQ
    is shut down. Auto-deleted exchanges are removed once the last bound object unbound
    from the exchange.
     */

    /**
     * Creating a bean for first queue
     *
     * @return queue
     */
    @Bean
    Queue queueFirst() {
        return new Queue(QUEUE_FIRST_NAME, true);
    }

    /**
     * Creating a bean for first queue
     *
     * @return queue
     */
    @Bean
    Queue queueSecond() {
        return new Queue(QUEUE_SECOND_NAME, true);
    }

    /**
     * Creating a bean for first queue
     *
     * @return queue
     */
    @Bean
    Queue queueThird() {
        return new Queue(QUEUE_THIRD_NAME, true);
    }

    /*
    Messages are not published directly to a queue, instead, the producer sends messages
    to an exchange.Exchanges are message routing agents, defined per virtual host within
    RabbitMQ. An exchange is responsible for the routing of the messages to the different
    queues. An exchange accepts messages from the producer application and routes
    them to message queues with help of header attributes, bindings, and routing keys.
     */

    /**
     * exchange() method
     *
     * @return the TopicExchange
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /*
     A binding is a "link" that you set up to bind a queue to an exchange.
     */

    /**
     * bindingFirst() method will bind the first queue to topic exchange with
     * routing key attribute for first consumer
     *
     * @return Binding
     */
    @Bean
    Binding bindingFirst() {
        return BindingBuilder.bind(queueFirst()).to(exchange()).with(ROUTING_FIRST_KEY);
    }

    /**
     * bindingSecond() method will bind the second queue to topic exchange with
     * routing key attribute for second consumer
     *
     * @return Binding
     */
    @Bean
    Binding bindingSecond() {
        return BindingBuilder.bind(queueSecond()).to(exchange()).with(ROUTING_SECOND_KEY);
    }

    /**
     * bindingThird() method will bind the third queue to topic exchange with
     * routing key attribute for third consumer
     *
     * @return Binding
     */
    @Bean
    Binding bindingThird() {
        return BindingBuilder.bind(queueThird()).to(exchange()).with(ROUTING_THIRD_KEY);
    }


}
