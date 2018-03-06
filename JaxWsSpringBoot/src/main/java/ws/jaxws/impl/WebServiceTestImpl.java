package ws.jaxws.impl;

import org.springframework.stereotype.Component;
import ws.jaxws.WebServiceTest;

import javax.jws.WebService;

/**
 * Created by EGBoldyr on 06.03.18.
 */

@WebService(serviceName = "WebTest", endpointInterface = "ws.jaxws.WebServiceTest")
@Component
public class WebServiceTestImpl implements WebServiceTest {

    @Override
    public String test() {
        return "WebServiceTestMessage";
    }
}
