package web.config;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import web.servlet.ServletAllContacts;
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
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean registration() {
        ServletRegistrationBean regist = new ServletRegistrationBean(dispatcherServlet(), "/ws/*");
        regist.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return regist;
    }
}
