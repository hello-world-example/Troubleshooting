package xyz.kail.demo.troubleshooting.jsonde.conf;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

@Configuration
public class LocalConf implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        TimeUnit.SECONDS.sleep(30);
        System.out.println(InetAddress.getLocalHost().getHostName());
    }
}
