package com.baseSpring.baseSpring.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RabbitMQKuyruk implements Serializable {

    private String notificationMessageId;
    private Date createDate;
    private Boolean seen;
    private String message;


}
