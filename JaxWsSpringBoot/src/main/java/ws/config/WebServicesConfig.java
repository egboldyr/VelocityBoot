package ws.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import ws.jaxws.WebServiceTest;
import ws.jaxws.impl.WebServiceTestImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by EGBoldyr on 06.03.18.
 */

@EnableWs
@Configuration
public class WebServicesConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private WebServiceTest webServiceTest;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, webServiceTest);
        endpoint.publish("/web_service_test");
        return endpoint;
    }
}
