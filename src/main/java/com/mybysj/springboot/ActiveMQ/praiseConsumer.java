package com.mybysj.springboot.ActiveMQ;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@Component
public class praiseConsumer implements MessageListener {
    @JmsListener(destination = "ay.queue.high.concurrency.praise")
    public void onMessage(Message message) {
        ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;

        try {

            System.out.println("已经消费了一个"+activeMQTextMessage.getText());



        } catch (JMSException e) {
            System.out.println("接收消息出现异常");
            e.printStackTrace();
        }

    }
}
