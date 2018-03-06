package ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by EGBoldyr on 06.03.18.
 */

@SpringBootApplication
@ComponentScan("ws")
public class JaxWsBootStart {

    public static void main(String[] args) {
        SpringApplication.run(JaxWsBootStart.class, args);
    }
}
