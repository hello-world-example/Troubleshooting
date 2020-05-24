package xyz.kail.demo.troubleshooting.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y
 */
@SpringBootApplication
public class ArthasApp {

    public static void main(String[] args) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(20);
        SpringApplication.run(ArthasApp.class, args);
    }

}