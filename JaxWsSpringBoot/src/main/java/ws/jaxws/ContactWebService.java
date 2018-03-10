package ws.jaxws;

import ws.entity.Contact;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ContactWebService {

    @WebMethod
    boolean create(Contact contact);

    @WebMethod
    Contact read(Long id);

    @WebMethod
    boolean update(Contact contact);

    @WebMethod
    boolean delete(Contact contact);

    @WebMethod
    Contact[] findAll();

}
