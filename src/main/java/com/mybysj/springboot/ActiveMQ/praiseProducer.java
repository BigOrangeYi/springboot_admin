package com.mybysj.springboot.ActiveMQ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


@Component
public class praiseProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendMessage(Destination destination, String bookno)throws Exception{

        System.out.println("已经生产了一个"+bookno);
        jmsTemplate.convertAndSend(destination,bookno);
    }
}
