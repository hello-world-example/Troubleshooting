package xyz.kail.demo.troubleshooting.arthas.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CPUTask {

//    @Scheduled(cron = "* * * * * ?")
    public void print() throws IOException {
        for (;true;){

        }
    }

}
