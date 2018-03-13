package web.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.servlet.ServletNewContact;

import java.util.Arrays;

/**
 * Created by EGBoldyr on 13.03.18.
 *
 * Конфигурация внешних javax.servlet которые не описаны в контроллере Spring
 *
 */

@Configuration
public class ServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean registration() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new ServletNewContact());
        regist.setUrlMappings(Arrays.asList("/ws_new"));
        return regist;
    }
}
