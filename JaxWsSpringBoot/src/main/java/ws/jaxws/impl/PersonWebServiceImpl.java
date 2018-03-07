package ws.jaxws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.entity.Person;
import ws.jaxws.PersonWebService;
import ws.service.PersonService;

import javax.jws.WebService;

/**
 * Created by EGBoldyr on 07.03.18.
 */

@WebService(serviceName = "PeopleSrv", portName = "PeoplePort", endpointInterface = "ws.jaxws.PersonWebService")
@Component
public class PersonWebServiceImpl implements PersonWebService {

    @Autowired
    private PersonService service;

    @Override
    public boolean addPerson(Person person) {
        if (person == null) {
            return false;
        }
        service.add(person);
        return true;
    }

    @Override
    public Person getPerson(Long id) {
        return null;
    }

    @Override
    public Person[] getAllPersons() {
        return service.getAllPersons();
    }
}
