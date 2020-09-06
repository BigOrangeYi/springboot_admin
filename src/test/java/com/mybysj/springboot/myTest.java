package com.mybysj.springboot;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybysj.springboot.DaoInterface.UserMapper;
import com.mybysj.springboot.DaoInterface_JPA.UserMapper_JPA;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

@SpringBootTest
public class myTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate StringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private com.mybysj.springboot.ActiveMQ.praiseProducer praiseProducer;

    private static Destination destination=new ActiveMQQueue("ay.queue.high.concurrency.praise");
    @Autowired
    private UserMapper_JPA userMapper_jpa;
    @Test
    public void test(){
        System.out.println(userMapper.findAll());
    }
    @Test
    public void Test1() throws Exception {

            praiseProducer.sendMessage(destination, "包子");

        }

    }

