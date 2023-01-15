package com.baseSpring.baseSpring.listener;


import com.baseSpring.baseSpring.model.RabbitMQKuyruk;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

// burasıda dinleyip alcak mesajları

@Service
public class RabbitMQListener {

    //bunu properties den belirledigimiz şekilde alıor
    @RabbitListener(queues = "celilSahin-queue")
    public void  handleMessage(RabbitMQKuyruk rabbitMQKuyruk) {
        System.out.println(rabbitMQKuyruk.toString());
        System.out.println("Mesaj Alindi.........!!!!");
    }
}
