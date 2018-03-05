package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by kpetkov on 05.03.18.
 */

@SpringBootApplication
@ComponentScan("web")
public class VelocityBootStart {

    public static void main(String[] args) {
        SpringApplication.run(VelocityBootStart.class, args);
    }
}
