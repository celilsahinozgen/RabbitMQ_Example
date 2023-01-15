package com.baseSpring.baseSpring.Producer;


//datayı gonderen class bu olcak

import com.baseSpring.baseSpring.model.RabbitMQKuyruk;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    @PostConstruct
    public void init(){
        RabbitMQKuyruk rabbitMQKuyruk = new RabbitMQKuyruk();
        rabbitMQKuyruk.setNotificationMessageId(UUID.randomUUID().toString());
        rabbitMQKuyruk.setCreateDate(new Date());
        rabbitMQKuyruk.setMessage("Hellow word Bu bir RabbitMQ mesajıdır");
        rabbitMQKuyruk.setSeen(Boolean.FALSE);


        sendToQueue(rabbitMQKuyruk);
    }

    //kuyruga mesaj gönderen kişi
    private final RabbitTemplate rabbitTemplate;

        //mesajı biri key ile alacagız gelen mesajı da rabbitmqkuyruk a atacak
    public void sendToQueue(RabbitMQKuyruk rabbitMQKuyruk){
        System.out.println("RabbitMQKuyruk Sent ID: " + rabbitMQKuyruk.getNotificationMessageId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,rabbitMQKuyruk);
    }

}
