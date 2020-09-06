package com.mybysj.springboot.SchedulerTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class Scheduler1 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔2秒执行一次
    @Scheduled(fixedRate = 7200000)
    public void testTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }


}
