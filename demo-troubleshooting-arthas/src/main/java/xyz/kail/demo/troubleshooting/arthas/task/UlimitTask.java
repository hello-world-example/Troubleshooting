package xyz.kail.demo.troubleshooting.arthas.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class UlimitTask {

//    @Scheduled(cron = "* * * * * ?")
    public void print() throws IOException {
        System.out.println(Files.list(Paths.get("/tmp/")).count());

        for (int i = 0; i < 10; i++) {
            Files.list(Paths.get("/tmp/")).count();
        }
    }

}
