package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("web")
public class JaxWsWebClientBoot {

    public static void main(String[] args) {
        SpringApplication.run(JaxWsWebClientBoot.class, args);
    }
}
