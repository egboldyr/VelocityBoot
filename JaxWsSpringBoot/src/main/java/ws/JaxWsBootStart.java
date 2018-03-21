package ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by EGBoldyr on 06.03.18.
 */

@SpringBootApplication
@EnableResourceServer            /*Указываем что при запуске сервиса будет использоватся resource-сервис*/
@ComponentScan("ws")
public class JaxWsBootStart {

    public static void main(String[] args) {
        SpringApplication.run(JaxWsBootStart.class, args);
    }
}
