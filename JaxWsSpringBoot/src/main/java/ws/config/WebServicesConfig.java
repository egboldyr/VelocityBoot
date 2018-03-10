package ws.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import ws.jaxws.ContactWebService;
import ws.jaxws.PersonWebService;
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

    @Autowired
    private PersonWebService webPeoples;

    @Autowired
    private ContactWebService webContacts;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus);
        endpoint.publish("/web_service_test", webServiceTest);
        endpoint.publish("/peoples", webPeoples);
        endpoint.publish("/contacts", webContacts);
        return endpoint;
    }
}
