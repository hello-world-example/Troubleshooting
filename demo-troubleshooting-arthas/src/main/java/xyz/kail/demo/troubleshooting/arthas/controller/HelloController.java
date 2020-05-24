package xyz.kail.demo.troubleshooting.arthas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.kail.demo.troubleshooting.arthas.service.HelloService;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/index")
    public String index() {
        return "success";
    }

    @GetMapping("/logger")
    public String logger() {
        log.debug("success");
        log.info("success");
        log.warn("success");
        log.error("success");
        return "success";
    }

    @GetMapping("/params")
    public String params(String p) {
        return "success:" + helloService.trace(p);
    }

}
