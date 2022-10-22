package br.com.users.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    @Autowired
    public UserProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
