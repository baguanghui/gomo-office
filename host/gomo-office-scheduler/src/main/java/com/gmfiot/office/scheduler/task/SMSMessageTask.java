package com.gmfiot.office.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableAsync
public class SMSMessageTask {
    private static final Logger log = LoggerFactory.getLogger(SMSMessageTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(cron = "0/2 * * * * ?")
    public void reportCurrentTime() throws InterruptedException {
        log.info(Thread.currentThread().getName() + "===task run," + dateFormat.format(new Date()));
        Thread.sleep(16 * 1_000);
        //log.info("The time is now {}", dateFormat.format(new Date()));
        //System.out.printf("The time is now {}", dateFormat.format(new Date()));
    }
}
