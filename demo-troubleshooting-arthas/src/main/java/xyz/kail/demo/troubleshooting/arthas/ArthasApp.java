package xyz.kail.demo.troubleshooting.arthas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y
 */
@Slf4j
@EnableScheduling
@SpringBootApplication
public class ArthasApp {

    public static void main(String[] args) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(20);
        SpringApplication.run(ArthasApp.class, args);
    }

}