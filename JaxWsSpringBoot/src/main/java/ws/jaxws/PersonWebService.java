package ws.jaxws;

import ws.entity.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by EGBoldyr on 07.03.18.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonWebService {

    @WebMethod
    boolean addPerson(Person person);

    @WebMethod
    Person getPerson(Long id);

    @WebMethod
    Person[] getAllPersons();


}
