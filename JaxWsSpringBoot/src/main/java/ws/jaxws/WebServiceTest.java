package ws.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Created by EGBoldyr on 06.03.18.
 */

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceTest {

    @WebMethod
    String test();
}
