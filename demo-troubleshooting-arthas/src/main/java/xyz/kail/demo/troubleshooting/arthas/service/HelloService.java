package xyz.kail.demo.troubleshooting.arthas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {

    public String trace(String param) {
        log.info("param: {}", param);
        return param + " result";
    }

}
