package xyz.kail.demo.troubleshooting.arthas.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintSystemTask {

//    @Scheduled(cron = "*/5 * * * * ?")
    public void print() {
        System.out.println("property: " + System.getProperty("print"));

        System.out.println("env: " + System.getenv("PRINT"));
    }

}
