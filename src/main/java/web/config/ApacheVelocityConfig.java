package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import javax.servlet.Servlet;

/**
 * Created by EGBoldyr on 05.03.18.
 */

@Configuration
@ConditionalOnClass({ Servlet.class})
public class ApacheVelocityConfig {

    private final ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Bean
    public VelocityConfig velocityConfig() {
        VelocityConfigurer cfg = new VelocityConfigurer();
        cfg.setResourceLoader(resourceLoader);
        return cfg;
    }

    @Bean
    public ViewResolver viewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setViewClass(VelocityToolboxView.class);
        resolver.setPrefix("/templates/velocity/");
        resolver.setSuffix(".vm");
        return resolver;
    }
}
