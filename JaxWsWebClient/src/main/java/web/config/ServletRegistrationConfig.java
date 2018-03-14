package web.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.servlet.ServletAllContacts;
import web.servlet.ServletDeleteContact;
import web.servlet.ServletNewContact;

import java.util.Arrays;

/**
 * Created by EGBoldyr on 13.03.18.
 *
 * Конфигурация внешних javax.servlet которые не описаны в контроллере Spring
 *
 * Приходится для каждого отдельного сервлета описывать меппиинг
 *
 */

@Configuration
public class ServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean wsNew() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new ServletNewContact());
        regist.setUrlMappings(Arrays.asList("/ws/new"));
        return regist;
    }

    @Bean
    public ServletRegistrationBean wsDelete() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new ServletDeleteContact());
        regist.setUrlMappings(Arrays.asList("/ws/delete"));
        return regist;
    }

    @Bean
    public ServletRegistrationBean wsAll() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new ServletAllContacts());
        regist.setUrlMappings(Arrays.asList("/ws/all"));
        return regist;
    }
}
