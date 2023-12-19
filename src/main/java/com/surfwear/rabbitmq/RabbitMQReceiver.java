package com.surfwear.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = "#{queue.name}")
    public void receive(Object message) {
        System.out.println("Received Message: " + message);
    }
}

