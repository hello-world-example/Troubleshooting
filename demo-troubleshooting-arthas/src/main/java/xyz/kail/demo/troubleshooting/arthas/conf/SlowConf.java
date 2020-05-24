package xyz.kail.demo.troubleshooting.arthas.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class SlowConf {


    @PostConstruct
    public void init() throws InterruptedException {
        log.info("init...");
        for (int i = 0; i < 20_000; i++) {
            Thread.sleep(1);
        }
        log.info("init...ok");
    }
}
